package org.campus02.pingpong;

import java.io.*;
import java.net.Socket;

public class PingPongClient {

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket("localhost", 1111);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             // lese von der Kommandozeile
             BufferedReader cli = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // lese input von kommandozeile
            String input;
            while ((input = cli.readLine()) != null) {
                // wenn exit => dann beenden
                if (input.equals("exit")) {
                    // beenden
                    break;
                }

                // schicke input an den server
                bw.write(input);
                bw.newLine();
                bw.flush(); // !!!!!

                // lesen
                System.out.println(br.readLine());
            }
        }
    }
}
