package com.example.monojit.assignment2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MONOJIT on 2/11/2017.
 */

public class ContactsAdapter extends BaseAdapter {
    Context context;
    List <OurContactsList> ourContactsLists;
    public ContactsAdapter(Context context,List<OurContactsList> contacts){
        this.context=context;
        ourContactsLists=contacts;
    }

    @Override
    public int getCount() {
        return ourContactsLists.size();
    }

    @Override
    public Object getItem(int i) {
        return ourContactsLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.data,viewGroup,false);
            TextView name=(TextView)view.findViewById(R.id.name);
            TextView number=(TextView)view.findViewById(R.id.phonenumber);

            OurContactsList contacts=ourContactsLists.get(i);
            name.setText(contacts.name);
            number.setText(contacts.number);
        }
        return view;
    }
}
