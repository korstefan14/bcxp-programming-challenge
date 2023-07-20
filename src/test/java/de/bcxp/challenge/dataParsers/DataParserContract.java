package de.bcxp.challenge.dataParsers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;


/**
 * This contract is used to test the DataParser interface
 * Please note that this interface and CSVBeanDataParser pass their tests down to WeatherParserTest, allowing for a form of contract testing natively in JUnit5
 */
public interface DataParserContract {
    DataParser getInstance();

    @Test
    default void givenInstanceExists_ThenGetReaderReturnsReader() {
        assertNotNull(getInstance().getReader());
    }

    @Test
    default void givenInstanceExists_ThenReaderIsReady() throws IOException {
        assertTrue(getInstance().getReader().ready());
    }
}
