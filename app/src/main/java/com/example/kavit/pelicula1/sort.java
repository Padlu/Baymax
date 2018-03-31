package com.example.kavit.pelicula1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sort extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        Button b =(Button) findViewById(R.id.adv);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sort.this, MainActivity1.class);
           /* myIntent.putExtra("key", value);*/ //Optional parameters
                startActivity(myIntent);
            }
        });

        Button b1 =(Button) findViewById(R.id.com);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sort.this, MainActivity1.class);
           /* myIntent.putExtra("key", value);*/ //Optional parameters
                startActivity(myIntent);
            }
        });

        Button b2 =(Button) findViewById(R.id.hor);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sort.this, MainActivity1.class);
           /* myIntent.putExtra("key", value);*/ //Optional parameters
                startActivity(myIntent);
            }
        });

        Button b3 =(Button) findViewById(R.id.rom);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sort.this, MainActivity1.class);
           /* myIntent.putExtra("key", value);*/ //Optional parameters
                startActivity(myIntent);
            }
        });

        Button b4 =(Button) findViewById(R.id.thril);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sort.this, MainActivity1.class);
           /* myIntent.putExtra("key", value);*/ //Optional parameters
                startActivity(myIntent);
            }
        });
    }


}
