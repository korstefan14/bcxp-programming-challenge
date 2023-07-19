package de.bcxp.challenge.dataAccessors;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;


public interface DataAccessorContract {

    DataAccessor createInstance();

    @Test
    default void shouldThrowNullPointerExceptionWhenLocationIsNull() {
        // given
        String location = null;
        DataAccessor dataAccessor = createInstance();

        // when
        assertThrows(NullPointerException.class, ()->dataAccessor.access(location));
    }
    
    @Test
    default void shouldThrowFileNotFoundExceptionWhenGivenFileDoesntExist() {
        // given
        String location = "nonexistent";
        DataAccessor dataAccessor = createInstance();

        // when
        assertThrows(FileNotFoundException.class, ()->dataAccessor.access(location));
    }

}
