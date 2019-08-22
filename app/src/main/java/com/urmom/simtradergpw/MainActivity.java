package com.urmom.simtradergpw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
