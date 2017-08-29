package com.rz.usagesexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rz.sparkeddynamicmodel.AdapterDynamicArray;
import com.rz.sparkeddynamicmodel.ModelDynamic;
import com.rz.spinalnavdrawer.SpinalNavDrawer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rz Rasel on 2017-08-28.
 */

public class ActDashboard extends AppCompatActivity {
    private Activity activity;
    private Context context;
    //|------------------------------------------------------------|
    private Toolbar sysToolBar;
    private DrawerLayout sysDrawerLayout;
    private RelativeLayout sysIdDrawerContainer;
    private ListView sysDrawerList;
    private SpinalNavDrawer spinalNavDrawer;
    private SpinalNavDrawer.OnSetupSpinalToolBar onSetupSpinalToolBar;
    private SpinalNavDrawer.OnSetupSpinalNavDrawer onSetupSpinalNavDrawer;
    //|------------------------------------------------------------|
    private AdapterDynamicArray adapterDynamicArray;
    private ArrayList<ModelDynamic> modelDrawerItems = new ArrayList<ModelDynamic>();
    //|------------------------------------------------------------|

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dashboard);
        activity = this;
        context = this;
        //|------------------------------------------------------------|
        for (int count = 0; count < 20; count++) {
            HashMap<String, Object> mapItems = new HashMap();
            mapItems.clear();
            mapItems.put("title", getObjectValue("Title - " + count));
            mapItems.put("description", getObjectValue("Description - " + count));
            modelDrawerItems.add(getSetModelData(mapItems));
        }
        //|------------------------------------------------------------|
        sysDrawerList = (ListView) findViewById(R.id.sysDrawerList);
        sysToolBar = (Toolbar) findViewById(R.id.sysToolBar);
        sysDrawerLayout = (DrawerLayout) findViewById(R.id.sysDrawerLayout);
        sysIdDrawerContainer = (RelativeLayout) findViewById(R.id.sysIdDrawerContainer);
        //|------------------------------------------------------------|
        adapterDynamicArray = new AdapterDynamicArray(context, R.layout.layout_navigation_drawer_row, modelDrawerItems);
        ArrayList<AdapterDynamicArray.ModelRowViewHolder> listRowViewFields = null;
        listRowViewFields = new ArrayList<AdapterDynamicArray.ModelRowViewHolder>();
        listRowViewFields.add(adapterDynamicArray.onGetSetModelRowViewData(new TextView(context), "sysDrawerTitle", ""));
        listRowViewFields.add(adapterDynamicArray.onGetSetModelRowViewData(new TextView(context), "sysDrawerDescription", ""));
        adapterDynamicArray.onSetListRowViewFields(new AdapterDynamicArray.OnFieldListenerHandler() {
            @Override
            public void onSetFieldValue(ArrayList<AdapterDynamicArray.ModelRowViewHolder> argListRowViewFields, Object argObject) {
                ModelDynamic item = (ModelDynamic) argObject;
                TextView rowField = null;
                if (argListRowViewFields.size() > 0) {
                    rowField = (TextView) argListRowViewFields.get(0).getFieldObject();
                    rowField.setText(item.getMapItems().get("title").toString());
                    rowField = (TextView) argListRowViewFields.get(1).getFieldObject();
                    rowField.setText(item.getMapItems().get("description").toString());
                }
            }
        }, listRowViewFields);
        sysDrawerList.setAdapter(adapterDynamicArray);
        //|------------------------------------------------------------|
        spinalNavDrawer = new SpinalNavDrawer(activity, context);
        onSetupSpinalNavDrawer = spinalNavDrawer.new OnSetupSpinalNavDrawer();
        onSetupSpinalToolBar = spinalNavDrawer.new OnSetupSpinalToolBar();
        spinalNavDrawer.setToolBar(sysToolBar)
                .setDrawerLayout(sysDrawerLayout)
                .setDrawerContainerLayout(sysIdDrawerContainer)
                .setDrawerListView(sysDrawerList);
        onSetupSpinalToolBar.onHideActionBar()
                .onSetActionBar()
                .onSetTitleText("Spinal Drawer")
                .onShowHomeButton()
                .onSetTitleTextColor("#ffffff")
                .onSetBackgroundColor("#80000000")
                .onSetElevation(0);
        onSetupSpinalNavDrawer.onConfigureDrawer();
        //|------------------------------------------------------------|
        sysDrawerList.setOnItemClickListener(new OnNavigationDrawerClickListener());
        //|------------------------------------------------------------|
    }

    //|------------------------------------------------------------|
    private class OnNavigationDrawerClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> argParent, View argView, int argPosition, long argId) {
            Toast.makeText(context, "NAVIGATION_DRAWER_POSITION: " + argPosition, Toast.LENGTH_LONG).show();
            sysDrawerList.setItemChecked(argPosition, true);
            sysDrawerLayout.closeDrawer(sysIdDrawerContainer);
            //for (int pos = 0; pos < adapterDynamicArray.getCount(); pos++) {
            for (int pos = 0; pos <= sysDrawerList.getLastVisiblePosition() - sysDrawerList.getFirstVisiblePosition(); pos++) {
                //sysDrawerList.getChildAt(i).setBackgroundColor(Color.BLUE);
                View parentView = null;
                //View parentView = adapterDynamicArray.getView(pos, null, sysDrawerList);
                //sysDrawerList.getItemAtPosition(pos);
                parentView = sysDrawerList.getChildAt(pos);
                parentView.setBackgroundColor(Color.BLUE);
                //parentView.getCh
                //adapterDynamicArray.notifyDataSetChanged();
            }
            argParent.getChildAt(argPosition).setBackgroundColor(Color.YELLOW);
            /*DisplayView(position);
            adapterLstDrawer.setSelectedPosition(position - 0, true, colorPrimaryDark);*/
            adapterDynamicArray.notifyDataSetChanged();
        }
    }


    //|------------------------------------------------------------|
    @Override
    public boolean onOptionsItemSelected(MenuItem argMenuItem) {
        switch (argMenuItem.getItemId()) {
            case android.R.id.home:
                onSetupSpinalNavDrawer.onOptionsItemSelected(argMenuItem);
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
        onSetupSpinalNavDrawer.onConfigurationChanged(argNewConfig);
    }

    //|------------------------------------------------------------|
    //private ModelDynamic getSetModelData(String argKey, String argValue) {
    private ModelDynamic getSetModelData(HashMap<String, Object> argMapItems) {
        /*HashMap<String, Object> mapItems = new HashMap();
        mapItems.clear();
        mapItems.put(argKey, getObjectValue(argValue));*/
        return new ModelDynamic(argMapItems);
    }

    private Object getObjectValue(String argValue) {
        return argValue;
    }

    //|------------------------------------------------------------|
    //|------------------------------------------------------------|
    private void DisplayView(int position) {
        //FragmentManager fragmentManager = getFragmentManager();
        //fragmentEventListener;
        String toolbarTitle = "CMDSS";
        Fragment fragment = null;
        Bundle bundle = null;
        //fragment = new FragTest();
        if (fragment != null) {
            //FragmentManager fragmentManager = getFragmentManager();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //fragmentTransaction.replace(R.id.frame_container, Fragment.instantiate(ActSplash.this, fragment));
            if (bundle == null) {
                bundle = new Bundle();
            }
            //bundle.putSerializable(APPConstants.SESSION.KEY, userSession);
            fragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.sysFrameContainer, fragment);
            fragmentTransaction.commit();

            // update selected item and title, then close the drawer
            sysDrawerList.setItemChecked(position, true);
            sysDrawerList.setSelection(position);
            setTitle(toolbarTitle);
        } else {
            // error in creating fragment
            Log.e("Dashboard", "Error in creating fragment");
        }
        sysDrawerList.setItemChecked(position, true);
        sysDrawerLayout.closeDrawer(sysIdDrawerContainer);
    }
}
/*
***http://android.amberfog.com/?p=296
https://stackoverflow.com/questions/32352444/androidlayout-height-attr-actionbarsize-is-not-working-with-supportdesign2
https://stackoverflow.com/questions/23863218/how-to-get-parent-view-of-checkbox-in-listview-items

public View getViewByPosition(int pos, ListView listView) {
final int firstListItemPosition = listView.getFirstVisiblePosition();
final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

if (pos < firstListItemPosition || pos > lastListItemPosition ) {
    return listView.getAdapter().getView(pos, null, listView);
} else {
    final int childIndex = pos - firstListItemPosition;
    return listView.getChildAt(childIndex);
}}
*/