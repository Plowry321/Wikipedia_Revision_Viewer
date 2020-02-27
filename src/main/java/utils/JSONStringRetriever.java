package utils;

import java.util.*;
import java.io.*;
import java.net.*;

public class JSONStringRetriever {
    private String input;

    public JSONStringRetriever(String input) {
        this.input = input;
    }

    public String getJSONstring() throws IOException {
        input = input.replaceAll(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + input + "&rvprop=timestamp|user&rvlimit=30&redirects");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Revision Tracker/0.1 (http://www.cs.bsu.edu/; yourusername@bsu.edu)");
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);
        String result = scanner.nextLine();
        if (result.contains("\"pages\":{\"-1\"")) {
            return "Error";
        }
        return result;
    }

    public boolean isConnected() {
        try {
            URL url = new URL("http://www.wikipedia.org");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
