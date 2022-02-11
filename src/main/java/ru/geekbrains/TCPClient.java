package ru.geekbrains;

import ru.geekbrains.connection.TCPConnection;
import ru.geekbrains.connection.TCPConnectionListener;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient implements TCPConnectionListener {

    public static void main(String[] args) {
        new TCPClient();
    }

    private TCPClient() {
        try (
                Socket clientSocket = new Socket("localhost", 8189);
                Scanner scanner = new Scanner(System.in)
        ) {
            TCPConnection connection = new TCPConnection(this, clientSocket);

            while (true) {
                if (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    connection.sendString(message);

                    if (message.equals("/end")) {
                        connection.disconnect();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("TCPConnection exception:" + e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection connection) {
        System.out.println("Connected to Server.");
    }

    @Override
    public synchronized void onReceiveString(TCPConnection connection, String value) {
        System.out.println("Server: " + value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection connection) {
        System.out.println("disconnected");
    }

    @Override
    public synchronized void onException(TCPConnection connection, Exception e) {
        System.out.println("TCPConnection exception2: " + e);
    }
}
