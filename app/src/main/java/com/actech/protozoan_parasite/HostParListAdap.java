package com.actech.protozoan_parasite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ACTECH on 6/27/2018.
 */

public class HostParListAdap extends BaseAdapter{
    Context context;
    List<HostPar> lst;

    public HostParListAdap(Context context, List<HostPar> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.item_hostpar, null);
        TextView tvanimalname = (TextView)v.findViewById(R.id.textView3);
        TextView tvorgan = (TextView)v.findViewById(R.id.textView5);
        TextView tvtyppar = (TextView)v.findViewById(R.id.textView7);
        TextView tvnampar = (TextView)v.findViewById(R.id.textView9);
        tvanimalname.setText(lst.get(position).getAnimal());
        tvorgan.setText(lst.get(position).getOrgan());
        tvtyppar.setText(lst.get(position).getType());
        tvnampar.setText(lst.get(position).getParname());

        return v;

    }
}
