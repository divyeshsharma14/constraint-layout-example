package com.example.constraintlayout.demo.presenters;

import com.example.constraintlayout.demo.datamodels.ExpSectionData;
import com.example.constraintlayout.demo.datamodels.JobsData;
import com.example.constraintlayout.demo.interfaces.IActivityView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenters {

    private IActivityView mView;

    public MainActivityPresenters(IActivityView view) {
        mView = view;
    }

    public void showExpDetails(String dataString) {
        mView.updateExpDetails(parseExpDetails(dataString));
    }

    private ExpSectionData parseExpDetails(String dataString) {
        ExpSectionData expSectionData = new ExpSectionData();
        try {
            JSONObject jsonObject = new JSONObject(dataString);
            expSectionData.setHeaderTitle(jsonObject.getString("section"));
            JSONArray jsonArray = jsonObject.getJSONArray("jobs");
            List<JobsData> jobList = new ArrayList<>();
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jObj = jsonArray.getJSONObject(i);
                JobsData jobsData = new JobsData();
                jobsData.setJobRole(jObj.getString("role"));
                jobsData.setJobTitle(jObj.getString("job"));
                jobsData.setJobDuration(jObj.getString("dates"));
                jobList.add(jobsData);
            }
            expSectionData.setJobsList(jobList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return expSectionData;
    }
}
