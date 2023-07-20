package de.bcxp.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

public class CountriesHandlerTest {
    @Test
    public void testHandle() throws FileNotFoundException, IOException, CsvException {
        (new CountriesHandler()).handle();
    }
}
