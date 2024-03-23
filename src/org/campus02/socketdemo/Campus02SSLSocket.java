package org.campus02.socketdemo;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Campus02SSLSocket {

    public static void main(String[] args) {
        try (Socket socket = SSLSocketFactory
                .getDefault()
                .createSocket("www.campus02.at", 443);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            bw.write("GET / HTTP/1.1");
            bw.newLine(); // \r\n
            bw.write("Host: www.campus02.at");
            bw.newLine();
            bw.newLine();
            bw.flush(); // !!!!!!!!!!!!!!!!!!!

            // antwort auf die konsole schreiben
            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
