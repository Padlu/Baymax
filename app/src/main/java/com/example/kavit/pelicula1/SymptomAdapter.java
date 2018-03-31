package com.example.kavit.pelicula1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

/**
 * Created by abhishekpadalkar on 3/31/18.
 */

public class SymptomAdapter extends ArrayAdapter<Symptom>{

    // boolean array for storing the state of each CheckBox
    boolean[] checkBoxState;

    ViewHolder viewHolder;

    //class for caching the views in a row
    private class ViewHolder
    {
        TextView nameTextView;
        CheckBox checkBox;
    }

    public SymptomAdapter(OnCompleteListener<QuerySnapshot> context, int resource, List<Symptom> symptoms) {
        super((Context) context, resource, symptoms);
        //create the boolean array with
        //initial state as false
        checkBoxState=new boolean[symptoms.size()];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.activity_item_symptom, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        Symptom symptom = getItem(position);

        nameTextView.setText(symptom.getName());

        //VITAL PART!!! Set the state of the
        //CheckBox using the boolean array
        viewHolder.checkBox.setChecked(checkBoxState[position]);


        //for managing the state of the boolean
        //array according to the state of the
        //CheckBox

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                    checkBoxState[position]=true;
                else
                    checkBoxState[position]=false;

            }
        });

        return convertView;
    }
}