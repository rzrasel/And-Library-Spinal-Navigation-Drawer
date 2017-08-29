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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Rz Rasel on 2017-08-28.
 */

public class SpinalNavDrawer {
    //|------------------------------------------------------------|
    private Activity activity;
    private Context context;
    //|------------------------------------------------------------|
    private Toolbar spinalToolBar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout spinalDrawerLayout;
    private RelativeLayout spinalDrawerContainerLayout;
    private ListView spinalDrawerContainerView;
    private ListView spinalDrawerList;

    //|------------------------------------------------------------|
    public SpinalNavDrawer(Activity argActivity, Context argContext) {
        this.activity = argActivity;
        this.context = argContext;
    }

    //|------------------------------------------------------------|
    public SpinalNavDrawer setToolBar(Toolbar argSpinalToolBar) {
        spinalToolBar = argSpinalToolBar;
        return this;
    }

    public SpinalNavDrawer setDrawerLayout(DrawerLayout argSpinalDrawerLayout) {
        spinalDrawerLayout = argSpinalDrawerLayout;
        return this;
    }

    public SpinalNavDrawer setDrawerContainerLayout(RelativeLayout argSpinalDrawerContainerLayout) {
        spinalDrawerContainerLayout = argSpinalDrawerContainerLayout;
        return this;
    }

    public SpinalNavDrawer setDrawerContainerLayout(ListView argSpinalDrawerContainerView) {
        spinalDrawerContainerView = argSpinalDrawerContainerView;
        return this;
    }

    public SpinalNavDrawer setDrawerListView(ListView argSpinalDrawerList) {
        spinalDrawerList = argSpinalDrawerList;
        return this;
    }

    //|------------------------------------------------------------|
    public class OnSetupSpinalToolBar {
        public OnSetupSpinalToolBar() {
            //|------------------------------------------------------------ |
            /*ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.hide();
            if (argSysToolBar != null) {
                setSupportActionBar(argSysToolBar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }*/
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
        }

        public OnSetupSpinalToolBar onHideActionBar() {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null)
                actionBar.hide();
            return this;
        }

        public OnSetupSpinalToolBar onSetActionBar() {
            ((AppCompatActivity) activity).setSupportActionBar(spinalToolBar);
            return this;
        }

        public OnSetupSpinalToolBar onSetTitleTextColor(String argHtmlColorCode) {
            //"#ffffff"
            spinalToolBar.setTitleTextColor(Color.parseColor(argHtmlColorCode));
            return this;
        }

        public OnSetupSpinalToolBar onSetTitleText(String argTitle) {
            if (spinalToolBar != null) {
                spinalToolBar.setTitle(argTitle);
            } else {
                ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setTitle(argTitle);
                }
            }
            return this;
        }

        public OnSetupSpinalToolBar onSetTitleText(String argTitle, String argSubTitle) {
            if (spinalToolBar != null) {
                spinalToolBar.setTitle(argTitle);
                spinalToolBar.setSubtitle(argSubTitle);
            } else {
                ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setTitle(argTitle);
                    actionBar.setSubtitle(argSubTitle);
                }
            }
            return this;
        }

        public OnSetupSpinalToolBar onShowHomeButton() {
            ((AppCompatActivity) activity).getSupportActionBar().setHomeButtonEnabled(true);
            ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            return this;
        }

        public OnSetupSpinalToolBar onSetBackgroundColor(String argHtmlColorCode) {
            //"#80000000"
            ((AppCompatActivity) activity).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(argHtmlColorCode)));
            return this;
        }

        public OnSetupSpinalToolBar onSetElevation(int argElevation) {
            //0
            ((AppCompatActivity) activity).getSupportActionBar().setElevation(argElevation);
            return this;
        }
    }
    //|------------------------------------------------------------|

    public class OnSetupSpinalNavDrawer {

        //|------------------------------------------------------------|
        /*public OnSetupSpinalNavDrawer onConfigureToolBar() {
            //|------------------------------------------------------------ |
            return this;
        }*/

        public OnSetupSpinalNavDrawer onConfigureDrawer() {
            //|------------------------------------------------------------|
            actionBarDrawerToggle = new ActionBarDrawerToggle(activity, spinalDrawerLayout, com.rz.spinalnavdrawer.R.string.spinal_nav_drawer_open, com.rz.spinalnavdrawer.R.string.spinal_nav_drawer_close) {
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
            spinalDrawerLayout.addDrawerListener(actionBarDrawerToggle);
            //|------------------------------------------------------------|
            return this;
        }

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

    public class OnSetupSpinalDrawerItems {
        /*public class OnNavigationDrawerClickListener implements ListView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> argParent, View argView, int argPosition, long argId) {
                //Toast.makeText(context, "NAVIGATION_DRAWER_POSITION: " + argPosition, Toast.LENGTH_LONG).show();
                sysDrawerList.setItemChecked(argPosition, true);
                sysDrawerLayout.closeDrawer(sysIdDrawerContainer);
                for (int i = 0; i < sysDrawerList.getAdapter().getCount(); i++) {
                    sysDrawerList.getChildAt(i).setBackgroundColor(Color.BLUE);
                }
                argParent.getChildAt(argPosition).setBackgroundColor(Color.YELLOW);
                *//*DisplayView(position);
                adapterLstDrawer.setSelectedPosition(position - 0, true, colorPrimaryDark);*//*
                adapterDynamicArray.notifyDataSetChanged();
            }
        }*/
    }
}
/*
https://stackoverflow.com/questions/26788464/how-to-change-color-of-the-back-arrow-in-the-new-material-theme
*/