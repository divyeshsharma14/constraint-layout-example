package com.example.constraintlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.constraintlayout.demo.datamodels.ExpSectionData;
import com.example.constraintlayout.demo.datamodels.JobsData;
import com.example.constraintlayout.demo.interfaces.IActivityView;
import com.example.constraintlayout.demo.presenters.MainActivityPresenters;
import com.example.divyeshsharma.sonicdemoapp.R;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements IActivityView {

    private LinearLayout mExpMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExpMainLayout = findViewById(R.id.main_parent_layout);

        MainActivityPresenters mainActivityPresenters = new MainActivityPresenters(this);
        mainActivityPresenters.showExpDetails(getJSONFromAsset());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateExpDetails(ExpSectionData data) {

        LayoutInflater inflater = getLayoutInflater();
        View sectionHeaderLayout = inflater.inflate(R.layout.section_headers, null, false);

        mExpMainLayout.addView(sectionHeaderLayout);
        ((TextView) sectionHeaderLayout.findViewById(R.id.section_title)).setText(data.getHeaderTitle());
        for (JobsData jobsData: data.getJobsList()){
            View expSectionDetailedLayout = inflater.inflate(R.layout.experience_details_layout, null, false);
            mExpMainLayout.addView(expSectionDetailedLayout);
            ((TextView) expSectionDetailedLayout.findViewById(R.id.job_name)).setText(jobsData.getJobRole());
            ((TextView) expSectionDetailedLayout.findViewById(R.id.job_role)).setText(jobsData.getJobTitle());
            ((TextView) expSectionDetailedLayout.findViewById(R.id.job_duration)).setText(jobsData.getJobDuration());
        }
    }

    /**
     * Gets the Json file from the asset folder
     *
     * @return Json String
     */
    public String getJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("xyz.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
