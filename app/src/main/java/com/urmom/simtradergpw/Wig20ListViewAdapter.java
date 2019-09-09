package com.urmom.simtradergpw;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class Wig20ListViewAdapter extends ArrayAdapter<StockRecord> {

    private Context mContext;
    int mResource;

    public Wig20ListViewAdapter(Context context, int resource, ArrayList<StockRecord> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String ticker = getItem(position).getTicker();
        String last = getItem(position).getLast();
        String percentageChange = getItem(position).getPercentageChange();

        StockRecord stockRecord = new StockRecord(name,ticker,last,percentageChange);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvTicker = (TextView) convertView.findViewById(R.id.ticker);
        TextView tvLast = (TextView) convertView.findViewById(R.id.last);
        TextView tvPercentageChange = (TextView) convertView.findViewById(R.id.percentageChange);

        tvName.setText(name);
        tvTicker.setText(ticker);
        tvLast.setText(last);
        tvPercentageChange.setText(percentageChange);

        return convertView;
    }
}
