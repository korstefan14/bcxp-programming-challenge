package de.bcxp.challenge.dataAccessors;

public class DataAccessorTest implements DataAccessorContract{

    @Override
    public DataAccessor createInstance() {
        return new CSVDataAccessor();
    }
    
}
