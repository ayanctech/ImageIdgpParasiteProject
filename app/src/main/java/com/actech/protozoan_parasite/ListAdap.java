package com.actech.protozoan_parasite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ACTECH on 6/26/2018.
 */

public class ListAdap extends BaseAdapter{

    private Context mContext;
    private List<String> cgrpList;

    public ListAdap(Context mContext, List<String> cgrpList) {
        this.mContext = mContext;
        this.cgrpList = cgrpList;
    }

    @Override
    public int getCount() {
        return cgrpList.size();
    }

    @Override
    public Object getItem(int position) {
        return cgrpList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

  /*  @Override
    public long getItemId(int position) {
        return cgrpList.get(position).getId();
    }
*/


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.list_group, null);
        TextView cgname = v.findViewById(R.id.cgn);

        cgname.setText(cgrpList.get(position));


        return v;
    }

}
