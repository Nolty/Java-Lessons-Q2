package ru.geekbrains;

import ru.geekbrains.connection.TCPConnection;
import ru.geekbrains.connection.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer implements TCPConnectionListener {

    public static void main(String[] args) {
        new TCPServer();
    }

    private TCPServer() {
        System.out.println("Server running...");
        try (
                ServerSocket serverSocket = new ServerSocket(8189);
                Scanner scanner = new Scanner(System.in)
        ) {
            try {
                Socket clientSocked = serverSocket.accept();
                TCPConnection connection = new TCPConnection(this, clientSocked);

                while (!clientSocked.isClosed()) {
                    if (scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        connection.sendString(message);
                    }
                }
            } catch (IOException e) {
                System.out.println("TCPConnection exception:" + e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection connection) {
        System.out.println("Client connected: " + connection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection connection, String value) {
        if (value.equals("/end")) {
            connection.disconnect();
            return;
        }

        System.out.println("Client: " + value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection connection) {
        System.out.println("Client disconnected: " + connection);
        System.exit(0);
    }

    @Override
    public synchronized void onException(TCPConnection connection, Exception e) {
        System.out.println("TCPConnection exception: " + e);
    }
}
