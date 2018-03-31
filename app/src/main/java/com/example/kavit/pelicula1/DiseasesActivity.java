package com.example.kavit.pelicula1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DiseasesActivity extends AppCompatActivity {

    private ListView mDiseaseListView;
    private ArrayList<Disease> mDiseaseList;
    private DiseaseAdapter mDiseaseAdapter;
    private FirebaseFirestore db;
    private CollectionReference mDiseaseCollectionReference;
    private DocumentReference mDiseaseDocumentReference;
    private Button analyze;
    private final String TAG = "MainActivity1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);
        mDiseaseListView = (ListView) findViewById(R.id.disList);
        setup();

        getAllDiseases();
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

    public void getAllDiseases() {
        db.collection("disease")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            mDiseaseList = new ArrayList<Disease>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d("Diseases", document.getId() + " => " + document.getData().get("name"));
                                mDiseaseList.add(document.toObject(Disease.class));
                            }

                            mDiseaseAdapter = new DiseaseAdapter(DiseasesActivity.this , R.layout.activity_item_disease, mDiseaseList);
                            mDiseaseListView.setAdapter(mDiseaseAdapter);

                        } else {
                            Log.w("Diseases", "Error getting documents.", task.getException());
                        }
                    }
                    // [END get_all_users]
                });
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(DiseasesActivity.this, MainActivity.class);
        //Optional parameters
        startActivity(myIntent);
    }
}