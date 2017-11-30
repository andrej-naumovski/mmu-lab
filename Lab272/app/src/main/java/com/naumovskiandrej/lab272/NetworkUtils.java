package com.naumovskiandrej.lab272;

/**
 * Created by andrejnaumovski on 29.11.17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class NetworkUtils {
    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";

    public static String doGet(String url, String protocol) {
        if (protocol == HTTPS) {
            return doHttpsGet(protocol + url);
        }

        try {
            URL urlObject = new URL(protocol + url);
            HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
            return readFromConnection(conn);
        } catch (Exception e) {
            return "Error fetching.";
        }
    }

    private static String readFromConnection(URLConnection conn) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream is = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    private static String doHttpsGet(String url) {
        try {
            URL urlObject = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) urlObject.openConnection();
            return readFromConnection(conn);
        } catch (Exception e) {
            return "Error fetching.";
        }
    }
}
