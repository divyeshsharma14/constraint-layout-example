package com.example.constraintlayout.demo.datamodels;

import java.util.List;

public class ExpSectionData {
    private String mHeaderTitle;
    private List<JobsData> mJobsList;

    public String getHeaderTitle() {
        return mHeaderTitle;
    }

    public void setHeaderTitle(String mHeaderTitle) {
        this.mHeaderTitle = mHeaderTitle;
    }

    public List<JobsData> getJobsList() {
        return mJobsList;
    }

    public void setJobsList(List<JobsData> mJobsList) {
        this.mJobsList = mJobsList;
    }
}
