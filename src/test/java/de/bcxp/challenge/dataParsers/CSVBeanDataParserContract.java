package de.bcxp.challenge.dataParsers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public interface CSVBeanDataParserContract extends DataParserContract {
    CSVBeanDataParser getInstance();

    @Test
    default void givenInstanceExists_ThenGetSeperatorReturnsChar() {
        assertNotNull(getInstance().getSeperator());
    }

}
