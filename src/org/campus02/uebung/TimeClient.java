package org.campus02.uebung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {

    public static void main(String[] args) throws IOException {
        // Verbinde dich mit dem server
        try (Socket server = new Socket("localhost", 1111);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(server.getInputStream()))
        ) {
            // lese jetzt daten vom server
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Antwort vom Server: " + line);
            }
        }
    }
}
