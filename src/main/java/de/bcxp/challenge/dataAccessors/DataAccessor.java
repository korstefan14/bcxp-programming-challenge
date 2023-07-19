package de.bcxp.challenge.dataAccessors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public interface DataAccessor {
    List<List<String>> access(String location) throws FileNotFoundException, IOException, CsvException;
}
