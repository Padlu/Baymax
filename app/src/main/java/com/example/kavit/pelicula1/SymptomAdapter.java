package com.example.kavit.pelicula1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishekpadalkar on 3/31/18.
 */

public class SymptomAdapter extends ArrayAdapter<Symptom>{

    // boolean array for storing the state of each CheckBox
    boolean[] checkBoxState;

    public ArrayList<Symptom> selectedSymptoms;


    public SymptomAdapter(Context context, int resource, ArrayList<Symptom> symptoms) {
        super(context, resource, symptoms);
        //create the boolean array with
        //initial state as false
        checkBoxState=new boolean[symptoms.size()];

        selectedSymptoms = new ArrayList<>();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.activity_item_symptom, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        final Symptom symptom = getItem(position);

        nameTextView.setText(symptom.getName());


        //VITAL PART!!! Set the state of the
        //CheckBox using the boolean array
        checkBox.setChecked(checkBoxState[position]);


        //for managing the state of the boolean
        //array according to the state of the
        //CheckBox

        checkBox.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(((CheckBox)v).isChecked()) {
                    checkBoxState[position] = true;
                    addSymptom(symptom);
                    Log.e("SymptomAdapter", selectedSymptoms.toString());
                }
                else {
                    checkBoxState[position] = false;
                    removeSymptom(symptom);
                    Log.e("SymptomAdapter", selectedSymptoms.toString());
                }
            }
        });

        return convertView;
    }

    public void addSymptom(Symptom symptom){ selectedSymptoms.add(symptom); }

    public void removeSymptom(Symptom symptom){ selectedSymptoms.remove(symptom); }

    public ArrayList<Symptom> getSelectedSymptoms(){  return selectedSymptoms;  }

}