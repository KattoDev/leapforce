package com.kattodev.leapforce.APIClient;

import DebugHandler.Debug;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.kattodev.leapforce.Models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.nio.charset.StandardCharsets;

public class Client {

    private final String api = "http://127.0.0.1:5000/api/";

    /**
     * Gets a resouce within API
     *
     * @param resource the resource that is fetched
     * @return a JSONArray with the response
     * @throws IOException        when connection isn't stablished.
     * @throws URISyntaxException if the url isn't correct.
     */
    public JsonArray MethodGET(String resource) throws IOException, URISyntaxException {
        URL url = new URI(api + resource).toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() != 200) {
            return JsonParser.parseString("[{\"error\": \"" + conn.getResponseCode() + "\"}]").getAsJsonArray();
        }

        new Debug("GET OK");
        return new Gson().fromJson(getString(conn), JsonArray.class);
    }

    /**
     * Posts a user to the API
     *
     * @param user the user to upload
     * @throws IOException
     * @throws URISyntaxException
     */
    public void methodPOST(User user) throws IOException, URISyntaxException {
        HttpURLConnection conn = getHttpURLConnection(user);

        if (conn.getResponseCode() != 200) {
            System.out.println("POST REQUEST NOT OK");
        } else {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {

                String inputLine;

                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                System.out.println(response);
            }
        }
    }

    /**
     * Gets the http connection with the API
     *
     * @param user an {@link User} instance to POST
     * @return the connection with the API
     * @throws URISyntaxException
     * @throws IOException
     */
    private HttpURLConnection getHttpURLConnection(User user) throws URISyntaxException, IOException {
        URL url = new URI(api + "users/").toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");

        // FOR POST ONLY - START
        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream()) {
            JsonArray sendInfo = user.getAsJSONArray();
            byte[] input = sendInfo.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            os.flush();
        }
        // FOR POST ONLY - END

        return conn;
    }

    /**
     * Gets a server response as string
     * @param conn the connection with the API
     * @return the response as string
     * @throws IOException
     * @throws RuntimeException
     */
    private static String getString(HttpURLConnection conn) throws IOException, RuntimeException {
        if (conn.getResponseCode() != 200) {
            // throw error if the server response isn't 200
            throw new RuntimeException("HTTP error code " + conn.getResponseCode());
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader((conn.getInputStream())));

        // StringBuilder to store response
        StringBuilder stringBuilder = new StringBuilder();
        int characterProcessed;
        while ((characterProcessed = bufferedReader.read()) != -1) {
            stringBuilder.append((char) characterProcessed);
        }

        // returns the server response
        return stringBuilder.toString();
    }
}
