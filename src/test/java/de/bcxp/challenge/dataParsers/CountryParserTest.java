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
import de.bcxp.challenge.models.ReducedCountry;
import de.bcxp.challenge.models.ReducedWeatherInformation;

public class CountryParserTest implements CSVBeanDataParserContract{

    @Override
    public CSVBeanDataParser getInstance() {
        try {
            return new CountryDataParser(new LocalFileReaderFactory().acquireReader("src/test/resources/countries.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new CountryDataParser(null);
    }

    @Test
    public void givenInvalidFile_WhenCallingAccess_ThenThrowsRuntimeException_WithCauseCsvException()
            throws FileNotFoundException {
        CountryDataParser parser = new CountryDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/invalidSemicolon.csv"));
        Executable executable = () -> parser.access();

        Exception exception = assertThrows(RuntimeException.class, executable);

        assertTrue(exception.getCause() instanceof CsvException);
    }

    @Test
    public void givenFileWithInvalidPopulationOrArea_WhenCallingAccess_ThenThrowsRuntimeException_WithCauseCsvConstraintViolationException()
            throws FileNotFoundException {
        CountryDataParser parser = new CountryDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/invalidPopulationAndArea.csv"));
        Executable executable = () -> parser.access();

        Exception exception = assertThrows(RuntimeException.class, executable);

        assertTrue(exception.getCause() instanceof CsvConstraintViolationException);
    }

    @Test
    public void givenValidFile_WhenCallingAccess_ThenReturnsListOfReducedWeatherInformation()
            throws FileNotFoundException {
        CountryDataParser parser = new CountryDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/countries.csv"));
        List<ReducedCountry> list = parser.access();
        assertTrue(list instanceof java.util.List);
        assertEquals(27, list.size());
    }

    @Test
    public void givenValidFileWithoutData_WhenCallingAccess_ThenReturnsEmptyList() throws FileNotFoundException {
        CountryDataParser parser = new CountryDataParser(
                new LocalFileReaderFactory().acquireReader("src/test/resources/justHeadersSemicolon.csv"));
        List<ReducedCountry> list = parser.access();
        assertTrue(list instanceof java.util.List);
        assertEquals(0, list.size());
    }
    
}
