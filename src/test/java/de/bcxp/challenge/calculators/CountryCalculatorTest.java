package de.bcxp.challenge.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.bcxp.challenge.models.ReducedCountry;
import de.bcxp.challenge.models.ReducedCountryBuilder;


public class CountryCalculatorTest {
    private static CountryCalculator countryCalculator;

    @BeforeAll
    public static void setUp() {
        countryCalculator = new CountryCalculator();
    }

    @Test
    public void givenNull_whenFindCountryWithHighestPopulationDensity_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> countryCalculator.findCountryWithHighestPopulationDensity(null));
    }

    @Test
    public void givenEmptyList_whenFindCountryWithHighestPopulationDensity_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> countryCalculator
                .findCountryWithHighestPopulationDensity(new ArrayList<ReducedCountry>()));
    }

    @Test
    public void givenListWithOneElement_whenFindCountryWithHighestPopulationDensity_thenReturnTheFirstArgumentsDay() {
        ArrayList<ReducedCountry> list = new ArrayList<ReducedCountry>();
        list.add(new ReducedCountryBuilder().build()); 
        assertEquals("TestCountry", countryCalculator.findCountryWithHighestPopulationDensity(list));

    }

    @Test
    public void givenListWithMoreThanOneElement_whenFindCountryWithHighestPopulationDensity_thenReturnTheCorrectCountry() {
        ArrayList<ReducedCountry> list = new ArrayList<ReducedCountry>();
        list.add(new ReducedCountryBuilder().withName("Albanien").withArea(5).withPopulation(140).build());
        list.add(new ReducedCountryBuilder().withName("Belgien").withArea(6).withPopulation(20).build()); 
        list.add(new ReducedCountryBuilder().withName("China").withArea(7).withPopulation(300000).build());
        list.add(new ReducedCountryBuilder().withName("Dänemark").withArea(8).withPopulation(300002).build());
        assertEquals("China", countryCalculator.findCountryWithHighestPopulationDensity(list));

    }
}
