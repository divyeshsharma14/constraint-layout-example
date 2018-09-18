package com.example.constraintlayout.demo.datamodels;

public class JobsData {
    private String mJobTitle;
    private String mJobRole;
    private String mJobDuration;

    public void setJobTitle(String mJobTitle) {
        this.mJobTitle = mJobTitle;
    }

    public void setJobRole(String mJobRole) {
        this.mJobRole = mJobRole;
    }

    public void setJobDuration(String mJobDuration) {
        this.mJobDuration = mJobDuration;
    }

    public String getJobTitle() {
        return mJobTitle;
    }

    public String getJobRole() {
        return mJobRole;
    }

    public String getJobDuration() {
        return mJobDuration;
    }
}
