package com.example.kavit.pelicula1;

/**
 * Created by kavit on 20-09-2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity1 extends AppCompatActivity {

    private ListView mSymptomListView;
    private ArrayList<Symptom> mSymptomList;
    private SymptomAdapter mSymptomAdapter;
    private FirebaseFirestore db;
    private CollectionReference mDiseaseCollectionReference;
    private DocumentReference mDiseaseDocumentReference;
    private Button analyze;
    private final String TAG = "MainActivity1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mSymptomListView = (ListView) findViewById(R.id.recList);
        setup();

        getAllSymptoms();

        analyze = (Button)findViewById(R.id.analyze_b);

        analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnalyzeButtonPressed();
            }
        });
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

    public void setup() {
        // [START get_firestore_instance]
        db = FirebaseFirestore.getInstance();
        // [END get_firestore_instance]

        // [START set_firestore_settings]
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        // [END set_firestore_settings]
    }

    public void getAllSymptoms() {
        db.collection("symptom")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            mSymptomList = new ArrayList<Symptom>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d("Symptoms", document.getId() + " => " + document.getData().get("name"));
                                mSymptomList.add(document.toObject(Symptom.class));
                            }

                            mSymptomAdapter = new SymptomAdapter(MainActivity1.this , R.layout.activity_item_symptom, mSymptomList);
                            mSymptomListView.setAdapter(mSymptomAdapter);

                        } else {
                            Log.w("Symptoms", "Error getting documents.", task.getException());
                        }
                    }
                    // [END get_all_users]
                });
    }

    public void onAnalyzeButtonPressed() {

        ArrayList<Symptom> mSelectedSymptoms = new ArrayList<Symptom>();
        mSelectedSymptoms = mSymptomAdapter.getSelectedSymptoms();

//inteny daal bro
        Intent myIntent = new Intent(MainActivity1.this, DiseasesActivity.class);
        startActivity(myIntent);

    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(MainActivity1.this, MainActivity.class);
        //Optional parameters
        startActivity(myIntent);
    }
}