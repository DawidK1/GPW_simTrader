package com.urmom.simtradergpw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Wig20Activity extends AppCompatActivity {

    ListView wig20ListView;
    ArrayList<StockRecord> mWig20records = null;


    Runnable mWig20Updater = new Runnable() {
        @Override
        public void run() {
            WebGateway webGateway = new WebGateway();
            mWig20records = webGateway.getPricesWig20();
            if (mWig20records != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showWig20();
                    }
                });

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wig20);

        wig20ListView = (ListView) findViewById(R.id.wig20ListView);


        Thread t = new Thread(mWig20Updater);
        t.start();

    }

    void showWig20() {
        Wig20ListViewAdapter adapter = new Wig20ListViewAdapter(this, R.layout.adapter_view_wig20, mWig20records);
        wig20ListView.setAdapter(adapter);
    }
}
