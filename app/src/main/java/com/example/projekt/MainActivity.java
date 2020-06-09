package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity  {

    int registracija = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner
        Spinner myspinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.skupine));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                //startActivity(new Intent(MainActivity.this,zalogaActivity.class));
                String skupina = parent.getItemAtPosition(i).toString();
                Toast.makeText(parent.getContext(), skupina, Toast.LENGTH_SHORT).show();
                if(i> 0 & registracija == 1) {
                    Intent intent = new Intent(MainActivity.this, regActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, skupina);
                    startActivity(intent);
                    registracija = 0;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        //gumb zaloga
        final Button button = findViewById(R.id.preveri);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                startActivity(new Intent(MainActivity.this, zalogaActivity.class));

            }
        });
        //gumb registracija
        final Button buttonreg = findViewById(R.id.postani);
        buttonreg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //startActivity(new Intent(MainActivity.this, regActivity.class));
                registracija = 1;


            }
        });


    }


}
