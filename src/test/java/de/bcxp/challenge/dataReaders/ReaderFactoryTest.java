package de.bcxp.challenge.dataReaders;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * This defines the reader factory contract
 * Please note that this interface passes its tests down to LocalFileReaderFactory , allowing for a form of contract testing natively in JUnit5
*/
 public interface ReaderFactoryTest {

    ReaderFactory getInstance();

    @BeforeEach
    default void setUp() {

    }

    @Test
    default void givenNullLocation_whenAcquireReader_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            getInstance().acquireReader(null);
        });
    }

    @Test
    default void givenNonExistingLocation_whenAcquireReader_thenThrowFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> {
            getInstance().acquireReader("nonExistingLocation");
        });
    }

    @Test
    default void givenExistingLocation_whenAcquireReader_thenNoException() {
        assertDoesNotThrow(() -> {
            getInstance().acquireReader("src/test/resources/validComma.csv");
        });
    }
}
