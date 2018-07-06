package com.actech.protozoan_parasite;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context _context;
	private List<String> _listDataHeader; // header titles
	// child data in format of header title, child title
	private HashMap<String, List<TProperties>> _listDataChild;

	public ExpandableListAdapter(Context context, List<String> listDataHeader,
			HashMap<String, List<TProperties>> listChildData) {
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		final TProperties childprop = (TProperties) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_item, null);
		}

		TextView txtListChild = convertView.findViewById(R.id.gname);
		TextView txtListChild2 =convertView.findViewById(R.id.doses);
		TextView txtListChild3 =convertView.findViewById(R.id.bname);
		TextView txtListChild4 =convertView.findViewById(R.id.chr);

		String s1=childprop.getGname(),s2=childprop.getDoses(),s3=childprop.getBname(),s4=childprop.getCharacteristics();

		if(!(s1.equals("") && s2.equals("") && s3.equals(""))) {
			if(!s1.equals(""))
			txtListChild.setText(s1);
			else {
				txtListChild3.setText("Same as above");
			}
			if(!s2.equals(""))
			txtListChild2.setText(s2);
			else {
				txtListChild3.setText("Same as above");
			}
			if (!s3.equals(""))
				txtListChild3.setText(s3);
			else {
				txtListChild3.setText("N.A");
			}
			if (!s3.equals(""))
				txtListChild4.setText(s4);
			else {
				txtListChild4.setText("   --  ");
			}
		}
		else{
			convertView.findViewById(R.id.gnm).setVisibility(View.GONE);
			convertView.findViewById(R.id.dss).setVisibility(View.GONE);
			convertView.findViewById(R.id.chd).setVisibility(View.GONE);
			convertView.findViewById(R.id.bnm).setVisibility(View.GONE);

			convertView.findViewById(R.id.gname).setVisibility(View.GONE);
			convertView.findViewById(R.id.doses).setVisibility(View.GONE);
			convertView.findViewById(R.id.bname).setVisibility(View.GONE);
			convertView.findViewById(R.id.chr).setVisibility(View.GONE);
		}
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this._listDataHeader.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this._listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_group, null);
		}

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.cgn);
		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setText(headerTitle);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
