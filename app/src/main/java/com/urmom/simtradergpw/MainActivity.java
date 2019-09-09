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

        StockRecord record1 = new StockRecord("Alior", "ALR", "40,4600", "0,90%");
        StockRecord record2 = new StockRecord("CCC", "CCC", "6,5000", "0,0937%");
        StockRecord record3 = new StockRecord("CDPROJEKT", "CDR", "260,0000", "1,76%");
        StockRecord record4 = new StockRecord("CYFRPLSAT", "CPS", "28,5400", "1,78%");

        /*################################################*/

        wig20ListView = (ListView) findViewById(R.id.wig20ListView);
        ArrayList<StockRecord> wig20ArrayList = new ArrayList<>();

        wig20ArrayList.add(record1);
        wig20ArrayList.add(record2);
        wig20ArrayList.add(record3);
        wig20ArrayList.add(record4);

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
