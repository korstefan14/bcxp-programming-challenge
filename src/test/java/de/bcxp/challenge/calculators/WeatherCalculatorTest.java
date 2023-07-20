package de.bcxp.challenge.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.bcxp.challenge.models.ReducedWeatherInformation;
import de.bcxp.challenge.models.ReducedWeatherInformationBuilder;

public class WeatherCalculatorTest {
    private static WeatherCalculator weatherCalculator;

    @BeforeAll
    public static void setUp() {
        weatherCalculator = new WeatherCalculator();
    }

    @Test
    public void givenNull_whenCalculateDayWithSmallestTemperatureSpread_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> weatherCalculator.calculateDayWithSmallestTemperatureSpread(null));
    }

    @Test
    public void givenEmptyList_whenCalculateDayWithSmallestTemperatureSpread_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> weatherCalculator
                .calculateDayWithSmallestTemperatureSpread(new ArrayList<ReducedWeatherInformation>()));
    }

    @Test
    public void givenListWithOneElement_whenCalculateDayWithSmallestTemperatureSpread_thenReturnTheFirstArgumentsDay() {
        ArrayList<ReducedWeatherInformation> list = new ArrayList<ReducedWeatherInformation>();
        list.add(new ReducedWeatherInformationBuilder().build());
        assertEquals(1, weatherCalculator.calculateDayWithSmallestTemperatureSpread(list));

    }

    @Test
    public void givenListWithMoreThanOneElement_whenCalculateDayWithSmallestTemperatureSpread_thenReturnTheFirstArgumentsDay() {
        ArrayList<ReducedWeatherInformation> list = new ArrayList<ReducedWeatherInformation>();
        list.add(new ReducedWeatherInformationBuilder().withDay(1).withMnT(5).withMxT(13).build());
        list.add(new ReducedWeatherInformationBuilder().withDay(2).withMnT(6).withMxT(8).build());
        list.add(new ReducedWeatherInformationBuilder().withDay(3).withMnT(7).withMxT(10).build());
        list.add(new ReducedWeatherInformationBuilder().withDay(4).withMnT(8).withMxT(11).build());
        assertEquals(2, weatherCalculator.calculateDayWithSmallestTemperatureSpread(list));

    }
}
