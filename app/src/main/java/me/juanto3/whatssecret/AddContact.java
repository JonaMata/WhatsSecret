package me.juanto3.whatssecret;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AddContact extends AppCompatActivity {

    private EditText nameEditText;

    private AddContactViewModel addContactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameEditText = findViewById(R.id.contactName);

        addContactViewModel = ViewModelProviders.of(this).get(AddContactViewModel.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameEditText != null) {
                    addContactViewModel.addContact(new Contact(nameEditText.getText().toString(), getHash(), (int) (System.currentTimeMillis() / 1000L)));
                    finish();
                }
            }
        });
    }

    private String getHash(){
        String hash = new String();
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            sr.nextBytes(salt);
            hash = new String(salt, Charset.forName("UTF-8"));
            Toast.makeText(this, "Generated hash: " + hash, Toast.LENGTH_LONG).show();
        } catch (NoSuchAlgorithmException e) {
            Toast.makeText(this, "Error creating hash, try again later", Toast.LENGTH_LONG).show();
            finish();
        }
        return hash;
    }

}
