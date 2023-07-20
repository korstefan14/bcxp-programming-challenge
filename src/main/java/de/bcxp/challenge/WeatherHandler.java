package de.bcxp.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import com.opencsv.exceptions.CsvException;

import de.bcxp.challenge.calculators.WeatherCalculator;
import de.bcxp.challenge.dataParsers.WeatherDataParser;
import de.bcxp.challenge.dataReaders.LocalFileReaderFactory;

public class WeatherHandler {
    
    public int handle() throws IOException, CsvException, FileNotFoundException {
        return new WeatherCalculator().calculateDayWithSmallestTemperatureSpread(new WeatherDataParser(new LocalFileReaderFactory().acquireReader("src/main/resources/de/bcxp/challenge/weather.csv")).access());

    }

    
}
