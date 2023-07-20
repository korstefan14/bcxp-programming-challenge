package de.bcxp.challenge.models;

public class ReducedCountryBuilder {
    String name = "TestCountry";
    int area = 5;
    int population = 100;

    public ReducedCountryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ReducedCountryBuilder withArea(int area) {
        this.area = area;
        return this;
    }

    public ReducedCountryBuilder withPopulation(int population) {
        this.population = population;
        return this;
    }

    public ReducedCountry build() {
        ReducedCountry reducedCountry = new ReducedCountry();
        reducedCountry.setName(name);
        reducedCountry.setArea(area);
        reducedCountry.setPopulation(population);
        return reducedCountry;
    }
}
