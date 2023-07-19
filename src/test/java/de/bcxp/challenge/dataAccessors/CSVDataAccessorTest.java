package de.bcxp.challenge.dataAccessors;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

public class CSVDataAccessorTest implements DataAccessorContract{

    @Override
    public DataAccessor createInstance() {
        return new CSVDataAccessor();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenLocationIsNotCSV() {
        // given
        String location = "src/test/resources/someLocation.txt";
        DataAccessor dataAccessor = createInstance();

        // when
        assertThrows(IllegalArgumentException.class, ()->dataAccessor.access(location));
    }
        @Test
    public void shouldThrowCsvExceptionWhenGivenFileIsNotValidCsv() {
        // given
        String location = "src/test/resources/invalid.csv";
        DataAccessor dataAccessor = createInstance();

        // when
        assertThrows(CsvException.class, ()->dataAccessor.access(location));
    }
    
}
