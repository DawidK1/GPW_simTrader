package com.urmom.simtradergpw;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StatisticsListViewAdapter extends ArrayAdapter<StockRecord> {
    private Context mContext;
    int mResource;

    public StatisticsListViewAdapter(Context context, int resource, ArrayList<StockRecord> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    //@NonNull
    @Override
    public View getView(int position, /*@Nullable*/ View convertView, /*@NonNull*/ ViewGroup parent) {
        String name = getItem(position).getName();
        String ticker = getItem(position).getTicker();
        String last = getItem(position).getLast();
        String percentageChange = getItem(position).getPercentageChange();
        String turnover = getItem(position).getTurnover();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = convertView.findViewById(R.id.instrumentName_textView);
        TextView tvPercentageChange = convertView.findViewById(R.id.instrumentChange_textView);
        TextView tvTurnover = convertView.findViewById(R.id.instrumentTurnover_textView);

        tvName.setText(name);
        tvPercentageChange.setText(percentageChange);
        tvTurnover.setText(turnover);

        return convertView;

    }
}
