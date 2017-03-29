package com.ecoach.cosapp.Activites;

import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;

import com.ecoach.cosapp.Activites.CompanyDetailsTabbedActivities.Details;
import com.ecoach.cosapp.Activites.CompanyDetailsTabbedActivities.Map;
import com.ecoach.cosapp.Activites.CompanyDetailsTabbedActivities.Profile;
import com.ecoach.cosapp.Application.Application;
import com.ecoach.cosapp.R;

public class CompanyDetails extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);


        // add back arrow to toolbar
        if (getSupportActionBar() != null){

            //getSupportActionBar().setTitle(Application.getSelectedCategoryName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setTabHost(savedInstanceState);
    }


    private void setTabHost(Bundle savedInstanceState){

    // create the TabHost that will contain the Tabs
    TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
        LocalActivityManager mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);
        tabHost.setup(mLocalActivityManager);
    // tabHost.setup();

    TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
    TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");
    TabHost.TabSpec tab3 = tabHost.newTabSpec("Third tab");

    tab1.setIndicator("Details");
    tab1.setContent(new Intent(this,Details.class));

    tab2.setIndicator("Profile");
    tab2.setContent(new Intent(this,Profile.class));

    tab3.setIndicator("Map");
    tab3.setContent(new Intent(this,Map.class));

    /** Add the tabs  to the TabHost to display. */
    tabHost.addTab(tab1);
    tabHost.addTab(tab2);
    tabHost.addTab(tab3);


}
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
