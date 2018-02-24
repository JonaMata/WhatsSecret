package me.juanto3.whatssecret;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView list;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         db = new DatabaseHandler(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact newContact = new Contact("Hans", "hash", (int) (System.currentTimeMillis() / 1000L));
                db.addContact(newContact);
                if (populateList()) {
                    Toast.makeText(MainActivity.this, "Succesfully added list item.", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Succesfully added list item.", Snackbar.LENGTH_LONG)
                    //        .setAction("Action", null).show();
                } else {
                    Toast.makeText(MainActivity.this, "Couldn't add list item.", Toast.LENGTH_SHORT).show();
                    //Snackbar.make(view, "Couldn't add list item.", Snackbar.LENGTH_LONG)
                    //        .setAction("Action", null).show();
                }
            }
        });
    }

    public boolean populateList() {
        List<Contact> contacts = db.getAllContacts();
        adapter.clear();
        for(Contact cn : contacts) {
            adapter.add(cn.getName());
        }
        return true;
    }

    public boolean addListItem() {
        adapter.add("Heyo, list item #" + Math.random() + " here");
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
