package de.bcxp.challenge.dataParsers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public interface DataParserContract {
    DataParser getInstance();

    @Test
    default void givenInstanceExists_ThenGetReaderReturnsReader(){
        assertNotNull(getInstance().getReader());
    }
    @Test
    default void givenInstanceExists_ThenReaderIsReady() throws IOException{
        assertTrue(getInstance().getReader().ready());
    }
}
