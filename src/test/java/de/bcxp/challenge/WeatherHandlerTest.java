package de.bcxp.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

public class WeatherHandlerTest {
    @Test
    public void testHandle() throws FileNotFoundException, IOException, CsvException {
        (new WeatherHandler()).handle();
    }
}
