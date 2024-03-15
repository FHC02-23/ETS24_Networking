package org.campus02.urldemo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstUrlDemo {

    public static void main(String[] args) {

        // implizit file: /
        // protokoll: https => port: 443
        String urlString = "https://www.campus02.at/startseite/oeffnungszeiten/";

        try {
            URL myUrl = new URL(urlString);

            // wir wollen nun lesen
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(myUrl.openStream()));
                 BufferedWriter bw = new BufferedWriter(
                         new FileWriter("data\\campus02.html"))) {

                String html;
                while ((html = br.readLine()) != null) {
                    //System.out.println(html);
                    bw.write(html);
                    bw.newLine(); // \r\n
                }

                bw.flush(); // !!!!!! schreiben

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
