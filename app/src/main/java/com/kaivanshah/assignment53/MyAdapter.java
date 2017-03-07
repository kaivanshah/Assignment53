package com.kaivanshah.assignment53;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by kaivanrasiklal.s on 07-03-2017.
 */

public class MyAdapter extends BaseAdapter {


    int TotalCount;
    Context myContext;
    private ArrayList<Contact> CustomerColl;

    public MyAdapter(int Count, Context oContext, ArrayList<Contact> oCustomerColl)
    {
        TotalCount = Count;
        myContext =  oContext;
        CustomerColl = oCustomerColl;
    }

    public MyAdapter()
    {

    }

    @Override
    public int getCount() {
        return TotalCount;
    }

    @Override
    public Object getItem(int position) {
        return CustomerColl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(myContext);
            row = inflater.inflate(R.layout.list_row, parent, false);
        }
        TextView tv_Name = (TextView)(row.findViewById(R.id.tv_Name));
        TextView tv_Phone = (TextView)(row.findViewById(R.id.tv_Phone));
        Contact objContact = (Contact) getItem(position);
        tv_Name.setText(objContact.getName());
        tv_Phone.setText(objContact.getPhoneNum());
        return  row;
    }
}
