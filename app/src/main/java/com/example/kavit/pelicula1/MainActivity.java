package com.example.kavit.pelicula1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ANONYMOUS = "anonymous";
    private static final int RC_SIGN_IN = 1;

    //private ProgressBar mProgressBar;

    private String mUsername;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDiseasesDatabaseReference;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = ANONYMOUS;

        //Initialize firebase components
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();

        mDiseasesDatabaseReference = mFirebaseDatabase.getReference().child("diseases");

        // Initialize references to views
        //mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Initialize progress bar
        //mProgressBar.setVisibility(ProgressBar.INVISIBLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAuthStateListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){ //this firebaseAuth parameter garuantees at this moment whether the user is authenticated or not
                FirebaseUser user = firebaseAuth.getCurrentUser();
                List<AuthUI.IdpConfig> providers = Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build());
                if (user != null) {
                    // User is signed in
                    Toast.makeText(MainActivity.this, "You're now signed in. Welcome to BaymaX.", Toast.LENGTH_SHORT).show();
                    onSignedInInitialize(user.getDisplayName());
                } else {
                    // User is signed out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false) //SmartLock allows the user to automatically save the user credentials and log them in
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);//RC is request code and we pass it to startActivityForResult, it's a flag for when we return from starting the activity for the results
                }

            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                //Sign-in succeded,set up the UI
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) { // when we go back to homescreen
                //Sign in was canceled by the user, finish the activity
                Toast.makeText(this, "Sign in Canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    private void onSignedInInitialize(String username){
        mUsername = username;
        //attachDatabaseReadListener();
    }

    private void onSignedOutCleanup(){
        mUsername = ANONYMOUS;
        //mMessageAdapter.clear();
        //detachDatabaseReadListener();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }/* else {
            super.onBackPressed();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the camera action
            Intent myIntent = new Intent(MainActivity.this, about.class);
            startActivity(myIntent);
        }
        if (id == R.id.nav_profile) {
            Intent myIntent = new Intent(MainActivity.this, ProfileActivity.class);
            MainActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_recc) {
            Intent myIntent = new Intent(MainActivity.this, sort.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_add_symptoms) {
            Intent myIntent = new Intent(MainActivity.this, MainActivity1.class);
            startActivity(myIntent);

        } else if (id == R.id.nav_logout) {
            AuthUI.getInstance().signOut(this);
            return true;

        } else if (id == R.id.nav_sort) {
            Intent myIntent = new Intent(MainActivity.this, MainActivity1.class);
            startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
