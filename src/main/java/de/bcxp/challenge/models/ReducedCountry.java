package de.bcxp.challenge.models;

import java.beans.JavaBean;

import com.opencsv.bean.CsvBindByName;

/**
 * This class is used to build ReducedCountry objects for testing purposes. I
 * got the idea from http://www.natpryce.com/articles/000714.html
 * (Although obviously the builder pattern is nothing new)
 */
@JavaBean
public class ReducedCountry {
    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Population", locale = "en-US", capture = "([^,]+),.*")
    private int population;

    @CsvBindByName(column = "Area (km\u00B2)")
    private int area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ReducedCountry [name=" + name + ", population=" + population + ", area=" + area + "]\n";
    }

}
