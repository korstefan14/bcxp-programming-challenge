package de.bcxp.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import de.bcxp.challenge.calculators.CountryCalculator;
import de.bcxp.challenge.dataParsers.CountryDataParser;
import de.bcxp.challenge.dataReaders.LocalFileReaderFactory;

public class CountriesHandler {

    /**
     * A handy Shortcut for calling the Countries Challenge
     * @return The country with the largest population density
     * @throws IOException
     * @throws CsvException
     * @throws FileNotFoundException
     */
    public String handle() throws IOException, CsvException, FileNotFoundException {
        return new CountryCalculator().findCountryWithHighestPopulationDensity(new CountryDataParser(
                new LocalFileReaderFactory().acquireReader("src/main/resources/de/bcxp/challenge/countries.csv"))
                .access());

    }
    
}
