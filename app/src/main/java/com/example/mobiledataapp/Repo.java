package com.example.mobiledataapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Repo implements Serializable
{


    public String getVolume_of_mobile_data() {
        return volume_of_mobile_data;
    }

    public void setVolume_of_mobile_data(String volume_of_mobile_data) {
        this.volume_of_mobile_data = volume_of_mobile_data;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Repo(String volume_of_mobile_data, String quarter, int _id) {
        this.volume_of_mobile_data = volume_of_mobile_data;
        this.quarter = quarter;
        this._id = _id;
    }

        public String volume_of_mobile_data;
        public String quarter;
        public int _id;


        public Repo()
        {}

}
