package com.example.mobiledataapp;

public class DbModel {
    String Year;
    String Total;
    String QuaterCount;

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getTotal() {
        return Total;
    }

    public DbModel(String year, String total, String quaterCount, String quater1, String quater2, String quater3) {
        Year = year;
        Total = total;
        QuaterCount = quaterCount;
        Quater1 = quater1;
        Quater2 = quater2;
        Quater3 = quater3;
    }

    public DbModel(String year, String total, String quaterCount, String quater1, String quater2, String quater3, String quater4) {
        Year = year;
        Total = total;
        QuaterCount = quaterCount;
        Quater1 = quater1;
        Quater2 = quater2;
        Quater3 = quater3;
        Quater4 = quater4;
    }

    public DbModel(String year, String total, String quaterCount, String quater1, String quater2) {
        Year = year;
        Total = total;
        QuaterCount = quaterCount;
        Quater1 = quater1;
        Quater2 = quater2;
    }

    public DbModel() {

    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getQuaterCount() {
        return QuaterCount;
    }

    public void setQuaterCount(String quaterCount) {
        QuaterCount = quaterCount;
    }

    public String getQuater1() {
        return Quater1;
    }

    public void setQuater1(String quater1) {
        Quater1 = quater1;
    }

    public String getQuater2() {
        return Quater2;
    }

    public void setQuater2(String quater2) {
        Quater2 = quater2;
    }

    public String getQuater3() {
        return Quater3;
    }

    public void setQuater3(String quater3) {
        Quater3 = quater3;
    }

    public String getQuater4() {
        return Quater4;
    }

    public void setQuater4(String quater4) {
        Quater4 = quater4;
    }

    String Quater1;
    String Quater2;
    String Quater3;
    String Quater4;

}
