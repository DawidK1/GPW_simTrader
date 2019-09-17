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

        Button showWIG20_btn = (Button)findViewById(R.id.showWIG20_btn);
        showWIG20_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Wig20Activity.class);
                startActivity(startIntent);
            }
        });

        Button myWallet_btn = (Button)findViewById(R.id.wallet_btn);
        myWallet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent (getApplicationContext(), WalletActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
