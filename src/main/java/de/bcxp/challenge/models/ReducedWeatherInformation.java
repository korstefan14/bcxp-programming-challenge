package de.bcxp.challenge.models;

import java.beans.JavaBean;

import com.opencsv.bean.CsvBindByName;

@JavaBean
public class ReducedWeatherInformation {

    @CsvBindByName
    private int Day;

    @CsvBindByName
    private int MxT;
    
    @CsvBindByName
    private int MnT;

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        this.Day = day;
    }

    public int getMxT() {
        return MxT;
    }

    public void setMxT(int maxTemp) {
        this.MxT = maxTemp;
    }

    public int getMnT() {
        return MnT;
    }

    public void setMnT(int minTemp) {
        this.MnT = minTemp;
    }

    @Override
    public String toString() {
        return "ReducedWeatherInformation [Day=" + Day + ", MxT=" + MxT + ", MnT=" + MnT + "]";
    }

}
