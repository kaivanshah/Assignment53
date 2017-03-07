package com.kaivanshah.assignment53;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_Contacts;
    private ArrayList<Contact> ContactColl;
    private MyAdapter oAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_Contacts = (ListView) this.findViewById(R.id.lv_Contacts);

        ContactColl = new ArrayList<Contact>();
        ContactColl.add(new Contact("ABC","1111111111"));
        ContactColl.add(new Contact("XYZ","2222222222"));
        ContactColl.add(new Contact("LMN","3333333333"));
        ContactColl.add(new Contact("PQR","4444444444"));

        oAdapter = new MyAdapter(ContactColl.size(), this, ContactColl);

        lv_Contacts.setAdapter(oAdapter);
        registerForContextMenu(lv_Contacts);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, 0, 0, "Call");//groupId, itemId, order, title
        menu.add(0, 1, 1, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Contact objContact = (ContactColl.get(item.getItemId()));
        if(item.getTitle()=="Call"){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + objContact.getPhoneNum()));
            try {
                startActivity(intent);
            }
            catch (SecurityException ex)
            {

            }




        }
        else if(item.getTitle()=="SMS"){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + objContact.getPhoneNum()));
            try {
                startActivity(intent);
            }
            catch (SecurityException ex)
            {

            }



        }
        else{
            return false;
        }
        return true;
    }


}
