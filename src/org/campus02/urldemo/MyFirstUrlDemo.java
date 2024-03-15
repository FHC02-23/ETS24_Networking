package org.campus02.urldemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstUrlDemo {

    public static void main(String[] args) {

        // implizit file: /
        // protokoll: https => port: 443
        String urlString = "https://www.campus02.at";

        try {
            URL myUrl = new URL(urlString);

            // wir wollen nun lesen
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(myUrl.openStream())
            )) {

                String html;
                while ((html = br.readLine()) != null) {
                    System.out.println(html);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
