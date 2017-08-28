package com.rz.spinalnavdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Rz Rasel on 2017-08-28.
 */

public class SpinalNavDrawer {
    //|------------------------------------------------------------|
    private Activity activity;
    private Context context;
    //|------------------------------------------------------------|
    private Toolbar sysToolBar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout sysDrawerLayout;
    private ListView sysDrawerList;

    //|------------------------------------------------------------|
    public SpinalNavDrawer() {
    }

    //|------------------------------------------------------------|
    public SpinalNavDrawer(Activity argActivity, Context argContext) {
        this.activity = argActivity;
        this.context = argContext;
    }

    //|------------------------------------------------------------|
    @Deprecated
    public void onInitActivity(Activity argActivity, Context argContext, Toolbar argSysToolBar) {
        this.activity = argActivity;
        this.context = argContext;
        this.sysToolBar = argSysToolBar;
        onConfigureToolBar(sysToolBar);
    }

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
    }

    public SpinalNavDrawer onConfigureToolBar(Toolbar argSysToolBar) {
        sysToolBar = argSysToolBar;
        /*ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        if (argSysToolBar != null) {
            setSupportActionBar(argSysToolBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
        //|------------------------------------------------------------ |
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        ((AppCompatActivity) activity).setSupportActionBar(sysToolBar);
        sysToolBar.setTitleTextColor(Color.parseColor("#ffffff"));
        ((AppCompatActivity) activity).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //((AppCompatActivity) activity).getSupportActionBar().setElevation(0);
        ((AppCompatActivity) activity).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
        //|------------------------------------------------------------ |
        /*ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        sysToolBar = argSysToolBar;
        //sysToolBar = (Toolbar) findViewById(R.id.sysToolBar);
        //sysToolBar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(sysToolBar);*/
        /*((AppCompatActivity) activity).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) activity).getSupportActionBar().setElevation(0);
        ((AppCompatActivity) activity).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));*/
        //|------------------------------------------------------------|
        return this;
    }

    public SpinalNavDrawer onConfigureDrawer(DrawerLayout argSysDrawerLayout) {
        //|------------------------------------------------------------|
        sysDrawerLayout = argSysDrawerLayout;
        //|------------------------------------------------------------|
        actionBarDrawerToggle = new ActionBarDrawerToggle(activity, argSysDrawerLayout, com.rz.spinalnavdrawer.R.string.spinal_nav_drawer_open, com.rz.spinalnavdrawer.R.string.spinal_nav_drawer_close) {
            /* Called when drawer is closed */
            public void onDrawerClosed(View view) {
                //Put your code here
                activity.invalidateOptionsMenu();
            }

            /* Called when a drawer is opened */
            public void onDrawerOpened(View drawerView) {
                //Put your code here
                activity.invalidateOptionsMenu();
            }
        };
        /*sysToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sysDrawerLayout.openDrawer(GravityCompat.START);
            }
        });*/
        actionBarDrawerToggle.syncState();
        sysDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        //|------------------------------------------------------------|
        return this;
    }

    //|------------------------------------------------------------|
    public void onPostCreate() {
        actionBarDrawerToggle.syncState();
    }

    public boolean onOptionsItemSelected(MenuItem argMenuItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(argMenuItem)) {
            return true;
        }
        /*switch (argMenuItem.getItemId()) {
            case android.R.id.home:
                sysDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }*/
        /*switch (argMenuItem.getItemId()) {
            case android.R.id.home:
                if (sysDrawerLayout.isDrawerOpen(drawerList)) {
                    sysDrawerLayout.closeDrawer(drawerList);
                } else {
                    sysDrawerLayout.openDrawer(drawerList);
                }
                return true;
            default:
                return super.onOptionsItemSelected(argMenuItem);
        }*/
        return false;
    }

    public void onConfigurationChanged(Configuration argNewConfig) {
        actionBarDrawerToggle.onConfigurationChanged(argNewConfig);
    }
    /*public void onCreate(int argLayoutResourceId) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootParentLayout = layoutInflater.inflate(argLayoutResourceId, null, false);
        sysTvRowTitle = (TextView) rootParentLayout.findViewById(R.id.sysTvRowTitle);
        sysTvRowTitle.setText("Test_TEXT");
    }*/
}
/*
https://stackoverflow.com/questions/26788464/how-to-change-color-of-the-back-arrow-in-the-new-material-theme
*/