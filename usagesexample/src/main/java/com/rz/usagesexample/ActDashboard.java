package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rz.spinalnavdrawer.SpinalNavDrawer;

/**
 * Created by Rz Rasel on 2017-08-28.
 */

public class ActDashboard extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private SpinalNavDrawer spinalNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dashboard);
        activity = this;
        context = this;
        Toolbar sysToolBar = (Toolbar) findViewById(R.id.sysToolBar);
        DrawerLayout sysDrawerLayout = (DrawerLayout) findViewById(R.id.sysDrawerLayout);
        spinalNavDrawer = new SpinalNavDrawer(activity, context);
        spinalNavDrawer.onConfigureToolBar(sysToolBar)
                .onConfigureDrawer(sysDrawerLayout);
    }

    //|------------------------------------------------------------|
    @Override
    public boolean onOptionsItemSelected(MenuItem argMenuItem) {
        switch (argMenuItem.getItemId()) {
            case android.R.id.home:
                spinalNavDrawer.onOptionsItemSelected(argMenuItem);
                return true;
            default:
                return super.onOptionsItemSelected(argMenuItem);
        }
        //System.out.println("----------------------");
        //return super.onOptionsItemSelected(argMenuItem);
    }

    //|------------------------------------------------------------|
    @Override
    public void onConfigurationChanged(Configuration argNewConfig) {
        super.onConfigurationChanged(argNewConfig);
        //spinalNavDrawer.onConfigurationChanged(argNewConfig);
    }
//|------------------------------------------------------------|
}