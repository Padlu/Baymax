package com.example.kavit.pelicula1;

/**
 * Created by kavit on 20-09-2017.
 */

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
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
    private SymptomAdapter mSymptomAdapter;
    private FirebaseFirestore db;
    private CollectionReference mDiseaseCollectionReference;
    private DocumentReference mDiseaseDocumentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        setup();

        getAllSymptoms();

        //mAdapter = new RecommendationAdapter(this, x);
        //mListView.setAdapter(mAdapter);


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
                           // ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Symptoms", document.getId() + " => " + document.getData().get("name"));
                               // symptoms[] = document.toObject(Symptom.class);
                            }
                        } else {
                            Log.w("Symptoms", "Error getting documents.", task.getException());
                        }
                    }
                });
        // [END get_all_users]
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(MainActivity1.this, MainActivity.class);
        //Optional parameters
        startActivity(myIntent);
    }
}