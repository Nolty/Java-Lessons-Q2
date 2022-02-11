package ru.geekbrains.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPConnection {
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final Thread rxThread;
    private final TCPConnectionListener listener;

    public TCPConnection(TCPConnectionListener listener, Socket socket) throws IOException {
        this.listener = listener;
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()) {
                        listener.onReceiveString(TCPConnection.this, in.readUTF());
                    }
                } catch (IOException e) {
                    listener.onException(TCPConnection.this, e);
                } finally {
                    listener.onDisconnect(TCPConnection.this);
                }
            }
        });

        rxThread.start();
    }

    public synchronized void sendString(String value) {
        try {
            out.writeUTF(value);
        } catch (IOException e) {
            listener.onException(TCPConnection.this, e);
            disconnect();
        }
    }

    public synchronized void disconnect() {
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            listener.onException(TCPConnection.this, e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection: " + socket.getInetAddress() + ":" + socket.getPort();
    }
}
