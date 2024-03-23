package org.campus02.pingpong;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

    public static void main(String[] args) {
        // server erstellen
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            // server soll ewig laufen
            while (true) {
                // server wartet auf verbindungen
                System.out.println("Server wartet auf Client");
                try (Socket client = serverSocket.accept();
                     // vom client lesen
                     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     // zum client schreiben/senden
                     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                ) {
                    System.out.println("Client hat sich verbunden");
                    // logik (was soll der der server machen)
                    // zuerst lesen
                    String line;
                    while ((line = br.readLine()) != null) {
                        // bei pong --> ping
                        // bei ping --> pong
                        // => alles andere -> ERROR
                        switch (line) {
                            case "PONG":
                                bw.write("--> PING");
                                break;
                            case "PING":
                                bw.write("--> PONG");
                                break;
                            default:
                                bw.write("--> ERROR");
                        }
                        bw.newLine();
                        bw.flush(); // !!!!!!!!!!!!!!!!!!!
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
