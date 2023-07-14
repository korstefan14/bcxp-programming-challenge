package de.bcxp.challenge.dataAccessors;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
    default void shouldThrowIllegalArgumentExceptionWhenLocationIsNotCSV() {
        // given
        String location = "someLocation";
        DataAccessor dataAccessor = createInstance();

        // when
        assertThrows(IllegalArgumentException.class, ()->dataAccessor.access(location));
    }
    
}
