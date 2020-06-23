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
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

public class PrevYearsActivity extends AppCompatActivity {

    AdView mAdView;
    //androidx.appcompat.app.ActionBar actionBar;
    DrawerLayout d1;
    ActionBarDrawerToggle navBarToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_years);

        /*Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        Log.d("Selected option no ", " "+position);
        BluePrint.shift(position);*/

        final RecyclerView userList = (RecyclerView) findViewById(R.id.userList);
        userList.setLayoutManager(new GridLayoutManager(this, 1));
        userList.setAdapter(new MyAdapter(PrevYearsActivity.this, BluePrint.currentNode.child));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        setToolbar();
        setNavigation();
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
                    Intent intent = new Intent(PrevYearsActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_item_2)
                {
                    Intent intent = new Intent(PrevYearsActivity.this, ContactUsActivity.class);
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
