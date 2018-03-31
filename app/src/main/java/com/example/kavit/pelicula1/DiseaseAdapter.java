package com.example.kavit.pelicula1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by abhishekpadalkar on 3/31/18.
 */

public class DiseaseAdapter extends ArrayAdapter<Disease>{
    public ArrayList<Disease> selectedDiseases;


    public DiseaseAdapter(Context context, int resource, ArrayList<Disease> diseases) {
        super(context, resource, diseases);

        selectedDiseases = new ArrayList<>();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.activity_item_disease, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.diseaseTextView);


        final Disease symptom = getItem(position);

        nameTextView.setText(symptom.getName());


        return convertView;
    }


}
