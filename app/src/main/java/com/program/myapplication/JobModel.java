package com.program.myapplication;

public class JobModel {
    private String company;
    private String info;
    private String sale;
    private String jobTime;
    private String vacancy;
    private String urlImage;
    public int idVacancy;



    public JobModel(int id, String company, String info, String sale, String jobTime, String vacancy, String urlImage) {
        this.idVacancy = id;
        this.company = company;
        this.info = info;
        this.sale = sale;
        this.jobTime = jobTime;
        this.vacancy = vacancy;
        this.urlImage = urlImage;
    }


    public String getCompany() {
        return company;
    }
    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
