package org.campus02.socketdemo;

import java.io.*;
import java.net.Socket;

public class CernClientSocket {

    public static void main(String[] args) {

        // server besteht bereits -> info.cern.ch:80
        // 1. zum server verbinden -> connection aufbauen
        // => erstellen einen socket

        // 2. wollen wir an den Server schicken
        // => socket.getOutputStream() um daten an srv zu schicken

        // 3. wollen wir die Antwort vom Server
        // => socket.getInputStream() um daten zu lesen

        // Verbindungsaufbau
        try (Socket socket = new Socket("info.cern.ch", 80);
             // an den server senden
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream())
             );
             // vom server lesen
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream())
             )
        ) {
            // zuerst schreiben -> daten an den server senden
            // http request (get)
//            bw.write("GET / HTTP/1.1\r\n");
//            bw.write("Host: info.cern.ch\r\n\r\n");
            bw.write("GET / HTTP/1.1");
            bw.newLine(); // \r\n
            bw.write("Host: info.cern.ch");
            bw.newLine();
            bw.newLine();
            bw.flush(); // !!!!!!!!!!!!!!!!!!!

            // request wurde geschickt
            // antwort auf die konsole schreiben
            // => wir lesen

            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
