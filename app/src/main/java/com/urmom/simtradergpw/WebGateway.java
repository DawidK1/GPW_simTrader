package com.urmom.simtradergpw;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class WebGateway {
    String TAG = "WebGateway";

    enum State {NAME, VALUE, CHANGE, CHANGE_PERCENT, NOTHING}

    ;
    private String preTemplate = "\" href=\"/inwestowanie/profile/quote.html?symbol=";
    private String pastTemplate = "</td>";

    ArrayList<StockRecord> getPricesWig20() {
        try {
            ArrayList<StockRecord> records = new ArrayList<>();
            StockRecord record = new StockRecord(null, null, null, null);
            State parserState = State.NOTHING;
            String inputLine, parsedLine;

            URL url = new URL("https://www.bankier.pl/inwestowanie/profile/quote.html?symbol=WIG20");

            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            // parse stream
            while ((inputLine = br.readLine()) != null) {

                switch (parserState) {

                    case NAME:
                        parsedLine = inputLine.replace("<td class=\"textAlignRight textNowrap\">", "").replace("</td>", "")
                                .replace(" ", "")
                                .replace("\t", "");

                        record.setTicker(parsedLine);
                        record.setName(parsedLine);
                        Log.d(TAG, "got name: " + parsedLine);
                        parserState = State.VALUE;
                        break;

                    case VALUE:
                        parsedLine = inputLine.replace("<td class=\"colKurs textAlignRight textNowrap change  up\">", "").replace("</td>", "")
                                .replace("<td class=\"colKurs textAlignRight textNowrap change  down\">", "").replace("</td>", "")
                                .replace(" ", "")
                                .replace("\t", "");

                        record.setLast(parsedLine);
                        Log.d(TAG, "got value: " + parsedLine);
                        parserState = State.CHANGE;
                        break;

                    case CHANGE:
                        parserState = State.CHANGE_PERCENT;
                        break;

                    case CHANGE_PERCENT:
                        parsedLine = inputLine.replace("<td class=\"textAlignRight textNowrap change  up\">", "").replace("</td>", "")
                                .replace("<td class=\"textAlignRight textNowrap change  down\">", "")
                                .replace("</td>", "")
                                .replace(" ", "")
                                .replace("\t", "");

                        record.setPercentageChange(parsedLine);
                        records.add(record);
                        Log.d(TAG, "got change percent: " + parsedLine);
                        parserState = State.NOTHING;

                    default:
                        // new record found
                        if (inputLine.contains(preTemplate)) {
                            parserState = State.NAME;
                            record = new StockRecord(null, null, null, null);
                            break;

                        }
                }
            }

            br.close();
            return records;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
