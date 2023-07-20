package de.bcxp.challenge.calculators;

import java.util.List;

import de.bcxp.challenge.models.ReducedCountry;

public class CountryCalculator {

    /**
     * Calculates the population density of a country
     * 
     * @param population The population of the country
     * @param area       The area of the country
     * @return The floating point value of the population density
     */
    private double calculatePopulationDensity(int population, int area) {
        double doublePopulation = population;
        double doubleArea = area;
        return doublePopulation / doubleArea;
    }

    /**
     * Finds the country with the highest population density in a given List
     * 
     * @param countries The list of countries from which the country with the
     *                  highest population density should be calculated
     * @return The name of the country with the highest population density
     */
    public String findCountryWithHighestPopulationDensity(List<ReducedCountry> countries) {
        if (countries == null) {
            throw new NullPointerException("Liste darf nicht null sein");
        }
        if (countries.isEmpty()) {
            throw new IllegalArgumentException("Liste darf nicht leer sein");
        }
        double highest = 0;
        String country = "";
        for (ReducedCountry reducedCountry : countries) {
            double populationDensity = calculatePopulationDensity(reducedCountry.getPopulation(),
                    reducedCountry.getArea());
            if (populationDensity > highest) {
                highest = populationDensity;
                country = reducedCountry.getName();
            }
        }
        return country;
    }
}
