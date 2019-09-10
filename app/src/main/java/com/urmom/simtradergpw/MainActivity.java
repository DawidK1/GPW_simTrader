package com.urmom.simtradergpw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView wig20ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*################################################*/

        StockRecord titleBar = new StockRecord("Nazwa:", "Ticker:", "Kurs:", "Zmiana w procentach:");
        StockRecord record1 = new StockRecord("ALIOR", "ALR", "40,4600", "0,90%");
        StockRecord record2 = new StockRecord("CCC", "CCC", "6,5000", "0,0937%");
        StockRecord record3 = new StockRecord("CDPROJEKT", "CDR", "260,0000", "1,76%");
        StockRecord record4 = new StockRecord("CYFRPLSAT", "CPS", "28,5400", "1,78%");
        StockRecord record5 = new StockRecord("DINOPL", "DNP", "147,4000", "-3,79%");
        StockRecord record6 = new StockRecord("JSW", "JSW", "28,2000", "-0,18%");
        StockRecord record7 = new StockRecord("KGHM", "KGH", "80,4200", "1,23%");
        StockRecord record8 = new StockRecord("LOTOS", "LTS", "85,0600", "-1,44%");
        StockRecord record9 = new StockRecord("LPP", "LPP", "7305,0000", "1,81%");
        StockRecord record10 = new StockRecord("MBANK", "MBK", "326,0000", "4,96%");
        StockRecord record11 = new StockRecord("ORANGEPL", "OPL", "5,98", "-1,32%");
        StockRecord record12 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record13 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record14 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record15 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record16 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record17 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record18 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record19 = new StockRecord("TEST", "TST", "0", "0%");
        StockRecord record20 = new StockRecord("TEST", "TST", "0", "0%");

        wig20ListView = (ListView) findViewById(R.id.wig20ListView);
        ArrayList<StockRecord> wig20ArrayList = new ArrayList<>();

        wig20ArrayList.add(titleBar);
        wig20ArrayList.add(record1);
        wig20ArrayList.add(record2);
        wig20ArrayList.add(record3);
        wig20ArrayList.add(record4);
        wig20ArrayList.add(record5);
        wig20ArrayList.add(record6);
        wig20ArrayList.add(record7);
        wig20ArrayList.add(record8);
        wig20ArrayList.add(record9);
        wig20ArrayList.add(record10);
        wig20ArrayList.add(record11);
        wig20ArrayList.add(record12);
        wig20ArrayList.add(record13);
        wig20ArrayList.add(record14);
        wig20ArrayList.add(record15);
        wig20ArrayList.add(record16);
        wig20ArrayList.add(record17);
        wig20ArrayList.add(record18);
        wig20ArrayList.add(record19);
        wig20ArrayList.add(record20);


        Wig20ListViewAdapter adapter= new Wig20ListViewAdapter(this,R.layout.adapter_view_layout, wig20ArrayList);
        wig20ListView.setAdapter(adapter);

        /*################################################*/
        Runnable r = new Runnable() {
            @Override
            public void run() {
                WebGateway webGateway = new WebGateway();
                webGateway.getPricesWig20();
            }
        };

        Thread t = new Thread(r);
        t.start();

    }


}
