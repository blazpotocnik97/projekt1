package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class regActivity extends AppCompatActivity {

    String ime,priim,email;
    int mobitel,posta;
    EditText name;
    EditText surname;
    EditText mobile;
    EditText post;
    EditText mail;
    Button savedata;

    String spol1;

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
        mail =(EditText) findViewById(R.id.mail);
        post =(EditText) findViewById(R.id.post);

        savedata = (Button) findViewById(R.id.savedata);

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ime = name.getText().toString();
                priim = surname.getText().toString();
                mobitel = Integer.valueOf(mobile.getText().toString());
                email = mail.getText().toString();
                posta = Integer.valueOf(post.getText().toString());

                Toast.makeText(regActivity.this, ime, Toast.LENGTH_SHORT).show();
                Toast.makeText(regActivity.this, priim, Toast.LENGTH_SHORT).show();
                Toast.makeText(regActivity.this, String.valueOf(mobitel), Toast.LENGTH_SHORT).show();
                Toast.makeText(regActivity.this, email, Toast.LENGTH_SHORT).show();
                Toast.makeText(regActivity.this, String.valueOf(posta), Toast.LENGTH_SHORT).show();
            }
        });




        ///spinner spol
        Spinner myspinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(regActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.spol));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);
        myspinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                //startActivity(new Intent(MainActivity.this,zalogaActivity.class));
                spol1 = parent.getItemAtPosition(i).toString();
                if (i > 0) {
                    Toast.makeText(parent.getContext(), spol1, Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }
}
