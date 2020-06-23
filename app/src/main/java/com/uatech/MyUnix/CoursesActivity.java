package com.uatech.MyUnix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

public class CoursesActivity extends AppCompatActivity {

    AdView mAdView;

    DrawerLayout d1;
    ActionBarDrawerToggle navBarToggle;
    //RecyclerView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        setToolbar();
        setNavigation();

        final RecyclerView userList = (RecyclerView) findViewById(R.id.userList);
        userList.setLayoutManager(new GridLayoutManager(this, 1));
        userList.setAdapter(new MyAdapter(CoursesActivity.this, BluePrint.currentNode.child));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BluePrint.backTraversal();
    }

    void setToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_email_black_24dp);
    }

    void setNavigation()
    {
        d1 = (DrawerLayout) findViewById(R.id.nav_drawer);
        navBarToggle = new ActionBarDrawerToggle(this, d1, R.string.Open, R.string.Close);
        navBarToggle.setDrawerIndicatorEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        //Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu_black_24dp, getCallingActivity().getThe)
        navBarToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_item_1)
                {
                    Toast.makeText(CoursesActivity.this, "item 1 selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CoursesActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_item_2)
                {
                    Toast.makeText(CoursesActivity.this, "item 2 selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CoursesActivity.this, ContactUsActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navBarToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }



    @Override
    protected void onResume() {
        super.onResume();
        //userList.setAdapter(new MyAdapter(CoursesActivity.this, BluePrint.currentNode.child));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Courses Activity", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Courses Activity", "onStop invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Courses Activity", "onDestry invoked");
    }

}
