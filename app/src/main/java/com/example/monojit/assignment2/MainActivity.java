package com.example.monojit.assignment2;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   List<OurContactsList>ourContactsLists;
    //TextView txt1;
   // TextView txt2;
    ListView contactsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView contactsList= (ListView)findViewById(R.id.contactsList);
        initOurContacts();
        ContactsAdapter contactsAdapter= new ContactsAdapter(this,ourContactsLists);
        contactsList.setAdapter(contactsAdapter);
        //txt1=(TextView)findViewById(R.id.name);
       // txt2=(TextView)findViewById(R.id.phonenumber);
       // registerForContextMenu(txt1);
       registerForContextMenu(contactsList);
    }
    void initOurContacts(){
        ourContactsLists=new ArrayList<OurContactsList>();
        ourContactsLists.add(new OurContactsList("Monoj","878787"));
        ourContactsLists.add(new OurContactsList("Arnab","787f7889"));
        ourContactsLists.add(new OurContactsList("Babai","646898908"));
        ourContactsLists.add(new OurContactsList("Hadoop","75709"));
        ourContactsLists.add(new OurContactsList("Tina","783769867"));
        ourContactsLists.add(new OurContactsList("Pankaj","8943058340"));
        ourContactsLists.add(new OurContactsList("Dilip","76790"));

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        OurContactsList clickitem;
        try
        {
            clickitem=new ContactsAdapter(this,ourContactsLists).ourContactsLists.get(info.position);



            if(item.getTitle()=="Call")
            {


                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+clickitem.number));
                startActivity(callIntent);

            }
            else if(item.getTitle()=="Send SMS")
            {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", clickitem.number, null));
                //smsIntent.setType("vnd.android-dir/mms-sms");
                //smsIntent.putExtra("address",clickitem.number);
                startActivity(smsIntent);


            }
            else
            {return false;}
            return true;
        }
        catch(Exception e)
        {
            return true;
        }
    }

}
