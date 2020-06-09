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


    String skupina;
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
                skupina = parent.getItemAtPosition(i).toString();
                if (i> 0){
                    Toast.makeText(parent.getContext(), skupina, Toast.LENGTH_SHORT).show();
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

                Intent intent = new Intent(MainActivity.this, regActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, skupina);
                startActivity(intent);


            }
        });


    }


}
