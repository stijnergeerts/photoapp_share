package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This service is used to make the backend call and retrieve the right event
 */
public class EventService {

    public String getJSON(String url) {
        HttpURLConnection c = null;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlJESkVNRFpFUmpJeE1qY3dOVFU0TkR" +
                    "Jd05EYzFOVUV4TkRFMU5EUXlNemcxUXpkQ056RkVRUSJ9.eyJuYW1lIjoiZ2xvYmVzaGFuZ2hhaUBvdXRsb29rLmNvbSIsIm5" +
                    "pY2tuYW1lIjoiZ2xvYmVzaGFuZ2hhaSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci9jN2IxMjVh" +
                    "ZGI1OGE5MjQxNTg4ZjI0NDcyMmRiNTFmNT9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhd" +
                    "GFycyUyRmdsLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDE3LTA2LTAyVDAyOjQ3OjAyLjA5NVoiLCJlbWFpbCI6Imdsb2Jlc2hhbm" +
                    "doYWlAb3V0bG9vay5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6Ly9nbG9iZXNoYW5naGFpLmF1LmF" +
                    "1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw1OTJmZGE1ZmEyZmM2ZTZlZDYyMTNkNjMiLCJhdWQiOiJvR2E0aWwzRVBwQVBrdVk2" +
                    "ODZCMjhmaE5lYTAyLTIxUCIsImV4cCI6MTQ5NjQwNzYyMiwiaWF0IjoxNDk2MzcxNjIyfQ.qW0fc7cOSR5vp4mfop7aBWUwye" +
                    "F7ae_jtgZRibH_58-DLxZIKdrpF0aMJGmLVYIKDrfKswKBfeuiANaR7sgRqb0pdKTsBMU_Qg0YVw0zofMU4lGORAM6ACOVypA" +
                    "gzI7VkXjLP2HHz7M0abnIbij9p2mcEHSM5URDdhcYzttJqXBBQtDDuWFKBXAc75SnCUknyn-QwwiklzILfari38gqTI14Oc6S" +
                    "MsdYmSdWm4EI_QpqiDPh7eSad0WfDceuCTNWmwVECkiVYFjTEVpeY2PWYpU1YBbwNQLdCJ-xDXmZ9TOwUGOty9eSBUDK_gsj3" +
                    "WbbkWAenQxGNyhkFfyh25SJvQ");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    return sb.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}

