package service;

import org.cloudinary.json.JSONException;
import org.cloudinary.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by stijnergeerts on 8/05/17.
 */
public class EventService {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public String getEvent(String url) throws IOException, InterruptedException {
        JSONObject jsonObject = readJsonFromUrl(url);
        return jsonObject.toString();
    }

    /*public static void main(String[] args) throws IOException {
        JSONObject jsonObject = readJsonFromUrl("https://photoapp-backend.herokuapp.com/api/event/getEventTextById/591032b5508f4c0004abd3cb");
        System.out.println(jsonObject);

    }*/
}

