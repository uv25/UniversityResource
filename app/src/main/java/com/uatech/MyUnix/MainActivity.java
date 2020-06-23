package com.uatech.MyUnix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    CardView cardView, cardView_mdu;
    AdView mAdView;
    DrawerLayout d1;
    ActionBarDrawerToggle navBarToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluePrint.treeReset();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        setToolbar();
        setNavigation();

        final RecyclerView userList = (RecyclerView) findViewById(R.id.userList);
        userList.setLayoutManager(new GridLayoutManager(this, 1));
        userList.setAdapter(new MyAdapter(MainActivity.this, BluePrint.currentNode.child));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 1);
            }
        }

    }



    void setToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
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
                    //Toast.makeText(MainActivity.this, "item 1 selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_item_2)
                {
                    //Toast.makeText(MainActivity.this, "item 2 selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, ContactUsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.down)
                {
                    Intent intent = new Intent(MainActivity.this, DownloadList.class);
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


}
