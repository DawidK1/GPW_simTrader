package com.urmom.simtradergpw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button myWallet_btn = (Button)findViewById(R.id.wallet_btn);
        myWallet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent (getApplicationContext(), WalletActivity.class);
                startActivity(startIntent);
            }
        });

        Button orders_btn = (Button)findViewById(R.id.orders_btn);
        orders_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), OrdersActivity.class);
                startActivity(startIntent);
            }
        });

        Button transactions_btn = (Button)findViewById(R.id.transactions_btn);
        transactions_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), TransactionsActivity.class);
                startActivity(startIntent);
            }
        });

        Button showWIG20_btn = (Button)findViewById(R.id.showWIG20_btn);
        showWIG20_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Wig20Activity.class);
                startActivity(startIntent);
            }
        });


        Button statistics_btn = (Button)findViewById(R.id.statistics_btn);
        statistics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), StatisticsActivity.class);
                startActivity(startIntent);
            }
        });

        Button settings_btn = (Button)findViewById(R.id.settings_btn);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
