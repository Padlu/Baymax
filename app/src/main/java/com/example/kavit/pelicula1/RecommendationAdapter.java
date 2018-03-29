package com.example.kavit.pelicula1;

/**
 * Created by kavit on 20-09-2017.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 19-09-2017.
 */

public class RecommendationAdapter extends ArrayAdapter<Disease> {

    ArrayList<Disease> x = new ArrayList<Disease>();

    public RecommendationAdapter(Context context, List<Disease> objects) {
        super(context, R.layout.recommendation_row ,objects);
        x.addAll(objects);
    }

    TextView Name, Genre, ID;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater listInflator = LayoutInflater.from(getContext());
        View listView = listInflator.inflate(R.layout.recommendation_row, parent, false);

        Name = (TextView) listView.findViewById(R.id.rec_name);
        Genre = (TextView) listView.findViewById(R.id.rec_genre);
     /*   ID = (TextView) listView.findViewById(R.id.rec_id);*/

        Disease singleMovie = x.get(position);

        Name.setText(singleMovie.getName());


        //ID.setText(singleMovie.getId());
        Genre.setText(singleMovie.getDesc());

        return listView;
    }
}

