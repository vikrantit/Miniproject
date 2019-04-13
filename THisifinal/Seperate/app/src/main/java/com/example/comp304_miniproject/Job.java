package com.example.comp304_miniproject;

public class Job {

    private int jobid;
    private String jobtitle;
    private String jobdesc;
    private int jobhours;
    private String jobpay;
    private int jobpostid;
    private int jobseekid;

    public Job(int jobid, String jobtitle, String jobdesc, int jobhours, String jobpay, int jobpostid, int jobseekid) {
        this.jobid = jobid;
        this.jobtitle = jobtitle;
        this.jobdesc = jobdesc;
        this.jobhours = jobhours;
        this.jobpay = jobpay;
        this.jobpostid = jobpostid;
        this.jobseekid = jobseekid;
    }

    public Job(){

    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public int getJobhours() {
        return jobhours;
    }

    public void setJobhours(int jobhours) {
        this.jobhours = jobhours;
    }

    public String getJobpay() {
        return jobpay;
    }

    public void setJobpay(String jobpay) {
        this.jobpay = jobpay;
    }

    public int getJobpostid() {
        return jobpostid;
    }

    public void setJobpostid(int jobpostid) {
        this.jobpostid = jobpostid;
    }

    public int getJobseekid() {
        return jobseekid;
    }

    public void setJobseekid(int jobseekid) {
        this.jobseekid = jobseekid;
    }
}
