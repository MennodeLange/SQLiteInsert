package com.app.menno.sqliteinsert;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Pass;
    myDbAdapter helper;

    // Wanneer de applicatie wordt opgestart
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Name and password
        Name = (EditText) findViewById(R.id.editName);
        Pass = (EditText) findViewById(R.id.editPass);

        // The dbAdapter
        helper = new myDbAdapter(this);
    }

    // Een user toevoegen
    public void addUser(View view)
    {
        // Wanneer een user wordt toegevoegd tekst in beeld: "Running"
        Toast.makeText(this,"Running", Toast.LENGTH_LONG).show();

        // Tekst krijgen uit de tekst en op een var zetten
        String name = Name.getText().toString();
        String password = Pass.getText().toString();

        long identity = helper.insertData(name, password);

        // Laat een message zien : "Succesful" or "Unsuccesful"
        if(identity < 0)
        {
            Message.message(this.getApplicationContext(),"Unsuccessful");
        } else
        {
            Message.message(this.getApplicationContext(),"Successful");
        }
    }
}
