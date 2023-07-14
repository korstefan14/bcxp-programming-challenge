package de.bcxp.challenge.dataAccessors;

import java.util.List;

public class CSVDataAccessor implements DataAccessor{

    @Override
    public List<List<String>> access(String location) {
        if(location==null) {
            throw new NullPointerException("Location must not be null");
        }
        if (!location.endsWith(".csv")) {
            throw new IllegalArgumentException("Only .csv files are supported");
        }
        return null;

    }
    
}
