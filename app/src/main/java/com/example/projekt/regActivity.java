package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class regActivity extends AppCompatActivity {

    String ime,priim;
    int mobitel;
    EditText name;
    EditText surname;
    EditText mobile;
    Button savedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        // get the text from MainActivity
        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        // use the text in a TextView
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(text);

        // ostala polja

        name =(EditText) findViewById(R.id.name);
        surname =(EditText) findViewById(R.id.surname);
        mobile =(EditText) findViewById(R.id.mobile);

        savedata = (Button) findViewById(R.id.savedata);

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ime = name.getText().toString();
                priim = surname.getText().toString();
                mobitel = Integer.valueOf(mobile.getText().toString());

                Toast.makeText(regActivity.this, ime, Toast.LENGTH_SHORT).show();
                Toast.makeText(regActivity.this, priim, Toast.LENGTH_SHORT).show();
                Toast.makeText(regActivity.this, String.valueOf(mobitel), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
