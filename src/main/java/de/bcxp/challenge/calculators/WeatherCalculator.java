package de.bcxp.challenge.calculators;

import java.util.List;

import de.bcxp.challenge.models.ReducedWeatherInformation;

public class WeatherCalculator {
    /**
     * @param info The list of weather information from which the day with the smallest temperature spread should be calculated
     * @return The day with the smallest temperature spread
     */
    public int calculateDayWithSmallestTemperatureSpread(List<ReducedWeatherInformation> info) {
        if (info == null) {
            throw new NullPointerException("Liste darf nicht null sein");
        }
        if (info.isEmpty()) {
            throw new IllegalArgumentException("Liste darf nicht leer sein");
        }

        int day = 999;
        int lowestValue = 999;
        for (ReducedWeatherInformation reducedWeatherInformation : info) {
            // System.out.printf("Day: %d, MxT: %d, MnT: %d%n",
            // reducedWeatherInformation.getDay(), reducedWeatherInformation.getMxT(),
            // reducedWeatherInformation.getMnT());
            if ((reducedWeatherInformation.getMxT() - reducedWeatherInformation.getMnT()) < lowestValue) {
                lowestValue = reducedWeatherInformation.getMxT() - reducedWeatherInformation.getMnT();
                day = reducedWeatherInformation.getDay();
            }

        }
        return day;
    }
}