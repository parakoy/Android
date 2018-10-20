package com.parakoy.app.wallet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment  fragment = null;
    public void displaySelectedScreen(int itemId) {

        Fragment  fragment2 = null;
        // Handle navigation view item clicks here.
        int id = 1;
        if (id == 1) {
            fragment2 = new NewFragment();
        }

        if (fragment2 != null) {
            int fragmentCount = fragmentManager.getBackStackEntryCount();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.hide(fragment);
                ft.add(R.id.screen_area, fragment2);
                 ft.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           fragment = new SettingsFragment();
        } else if (id == R.id.action_about){
            fragment = new AboutFragment();
        } else if (id == R.id.action_help){
            fragment = new HelpFragment();
        } else if (id == R.id.action_security){
            fragment =  new SecurityFragment();
        } else if (id == R.id.action_release) {
            fragment = new ReleaseFragment();
        }

        if (fragment != null) {

            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        Fragment  fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_start) {
            fragment = new StartFragment();
        } else if (id == R.id.nav_history) {
            fragment = new HistoryFragment();
        } else  if (id == R.id.nav_send) {
            fragment = new SendFragment();
        } else if (id == R.id.nav_wallet){
            fragment = new AddressFragment();
        } else if (id == R.id.nav_details){
            fragment = new DetailsFragment();
        }


        if (fragment != null) {

            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment);
            ft.commit();

           // FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
           // ft.replace(R.id.screen_area, fragment);
          //  ft.commit();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
