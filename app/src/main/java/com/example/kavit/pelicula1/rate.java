package com.example.kavit.pelicula1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Created by kavit on 22-09-2017.
 */

public class rate extends AppCompatActivity {
    double quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
    }

    public void save(View view) {

        Toast.makeText(getApplicationContext(),"Rating Saved",Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(rate.this, MainActivity1.class);
           /* myIntent.putExtra("key", value);*/ //Optional parameters
        startActivity(myIntent);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(double number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayRating(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {

            quantity = quantity + 0.5;
        if (quantity>=0 && quantity<=5) {
            display(quantity);
        }
        if(quantity<0 || quantity >5)
        {
            Toast.makeText(getApplicationContext(), "Invalid Rating", Toast.LENGTH_SHORT).show();
            quantity=0;
            display(quantity);
        }
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 0.5;
        if (quantity>=0 && quantity<=5) {
            display(quantity);
        }
        if(quantity<0 || quantity >5)
        {
            Toast.makeText(getApplicationContext(), "Invalid Rating", Toast.LENGTH_SHORT).show();
            quantity=0;
            display(quantity);
        }

    }
}
