package com.urmom.simtradergpw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {
    ListView topGainersListView;
    ArrayList<StockRecord> mTopGainersRecords = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        topGainersListView = (ListView) findViewById(R.id.topGainers_listView);


        /*-------------------------TEST-------------------------*/
        StockRecord record1 = new StockRecord("ALIOR", "ALR", "40,4600", "0,90%", "2137");
        StockRecord record2 = new StockRecord("CCC", "CCC", "6,5000", "0,0937%", "2137");
        StockRecord record3 = new StockRecord("CDPROJEKT", "CDR", "260,0000", "1,76%", "2137");
        StockRecord record4 = new StockRecord("CYFRPLSAT", "CPS", "28,5400", "1,78%", "2137");

        ArrayList<StockRecord> topGainersArrayList = new ArrayList<>();

        topGainersArrayList.add(record1);
        topGainersArrayList.add(record2);
        topGainersArrayList.add(record3);
        topGainersArrayList.add(record4);

       StatisticsListViewAdapter adapter = new StatisticsListViewAdapter(this, R.layout.adapter_view_statistics, topGainersArrayList);
       topGainersListView.setAdapter(adapter);
        /*------------------------------------------------------*/

    }
}
