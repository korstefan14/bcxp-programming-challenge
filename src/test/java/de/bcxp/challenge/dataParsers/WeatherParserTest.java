package de.bcxp.challenge.dataParsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvException;

import de.bcxp.challenge.dataReaders.LocalFileReaderFactory;
import de.bcxp.challenge.models.ReducedWeatherInformation;

/**
 * This class tests the WeatherDataParser
 * It receives some tests from CSVBeanDataParserContract and DataParserContract
 */
 
public class WeatherParserTest implements CSVBeanDataParserContract {

    @Override
    public CSVBeanDataParser getInstance() {
        try {
            return new WeatherDataParser(new LocalFileReaderFactory().acquireReader("src/test/resources/weather.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new WeatherDataParser(null);
    }

    @Test
    public void givenInvalidFile_WhenCallingAccess_ThenThrowsRuntimeException_WithCauseCsvException()
            throws FileNotFoundException {
        WeatherDataParser parser = new WeatherDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/invalidComma.csv"));
        Executable executable = () -> parser.access();

        Exception exception = assertThrows(RuntimeException.class, executable);

        assertTrue(exception.getCause() instanceof CsvException);
    }

    @Test
    public void givenFileWithInvalidTemperatures_WhenCallingAccess_ThenThrowsRuntimeException_WithCauseCsvConstraintViolationException()
            throws FileNotFoundException {
        WeatherDataParser parser = new WeatherDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/invalidTemps.csv"));
        Executable executable = () -> parser.access();

        Exception exception = assertThrows(RuntimeException.class, executable);

        assertTrue(exception.getCause() instanceof CsvConstraintViolationException);
    }

    @Test
    public void givenValidFile_WhenCallingAccess_ThenReturnsListOfReducedWeatherInformation()
            throws FileNotFoundException {
        WeatherDataParser parser = new WeatherDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/weather.csv"));
        List<ReducedWeatherInformation> list = parser.access();
        assertTrue(list instanceof java.util.List);
        assertEquals(30, list.size());
    }

    @Test
    public void givenValidFileWithoutData_WhenCallingAccess_ThenReturnsEmptyList() throws FileNotFoundException {
        WeatherDataParser parser = new WeatherDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/justHeadersComma.csv"));
        List<ReducedWeatherInformation> list = parser.access();
        assertTrue(list instanceof java.util.List);
        assertEquals(0, list.size());
    }
}
