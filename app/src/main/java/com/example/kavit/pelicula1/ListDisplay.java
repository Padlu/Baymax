package com.example.kavit.pelicula1;

/**
 * Created by kavit on 13-09-2017.
 */


        import android.os.Bundle;
        import android.app.ListActivity;
        import android.view.Menu;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

public class ListDisplay extends ListActivity {
    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

       /* ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);*/
    }
}