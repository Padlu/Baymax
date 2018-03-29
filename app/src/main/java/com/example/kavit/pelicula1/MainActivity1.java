package com.example.kavit.pelicula1;

/**
 * Created by kavit on 20-09-2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {
    private String USGS_URL =
            "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";


    private ListView mListView;
    private RecommendationAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        mListView = (ListView) findViewById(R.id.recList);
        ArrayList<Disease> x = new ArrayList<Disease>();
        x.add(new Disease("Scarlett Fever", "Virus"));

        mAdapter = new RecommendationAdapter(this, x);
        mListView.setAdapter(mAdapter);


     /*   mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Movie m = (Movie) adapter.getItemAtPosition(position);
                String s1 = m.getId();
                String s2 = m.getName();
                String s3 = m.getGenre();
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
                Intent myIntent = new Intent(MainActivity1.this, rate.class);
                //Optional parameters
                startActivity(myIntent);
            }
        });*/



    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(MainActivity1.this, MainActivity.class);
        //Optional parameters
        startActivity(myIntent);
    }
}