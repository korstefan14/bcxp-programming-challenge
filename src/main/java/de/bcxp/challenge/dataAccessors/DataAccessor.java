package de.bcxp.challenge.dataAccessors;

import java.util.List;

public interface DataAccessor {
    List<List<String>> access(String location);
}
