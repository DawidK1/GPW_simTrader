package com.urmom.simtradergpw;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebGateway {
    String TAG = "WebGateway";

    private String preTemplate = "<td class=\"textAlignRight textNowrap\">";
    private String pastTemplate ="</td>";
    public void getPricesWig20(){
        try{
            URL url = new URL("https://www.bankier.pl/inwestowanie/profile/quote.html?symbol=WIG20");

            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                Log.d(TAG,inputLine);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
