package org.campus02.uebung;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) {
        System.out.println("Erzeuge den Server");
        try(ServerSocket serverSocket = new ServerSocket(1111)) {
            while (true) {
                System.out.println("Warte auf Clients...");
                try(Socket client = serverSocket.accept()) {
                    System.out.println("Client hat sich verbunden");

                    // logik
                    TimeHandler timeHandler = new TimeHandler(client);
                    timeHandler.sendTime();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}