package de.bcxp.challenge;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */

public class App {

    /**
     * This is the main entry method of your program.
     * 
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        int dayWithSmallestTempSpread;
        try {
            dayWithSmallestTempSpread = new WeatherHandler().handle();
            System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestTempSpread);
        } catch (IOException | CsvException | RuntimeException e) {
            System.out.printf("Fehler: %s%n", e.getMessage());
            // e.printStackTrace();
        }

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
