package de.bcxp.challenge.dataAccessors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CSVDataAccessor implements DataAccessor{

    private String delimitor;

    @Override
    public List<List<String>> access(String location) throws FileNotFoundException, IOException, CsvException {
        if(location==null) {
            throw new NullPointerException("Location must not be null");
        }
        File f = new File(location);
            if(!f.exists() || f.isDirectory()) { 
                throw new FileNotFoundException("File not found");
        }
        

        if (!location.endsWith(".csv")) {
            throw new IllegalArgumentException("Only .csv files are supported");
        }
        

        
        // Create an object of filereader
        // class with CSV file as a parameter.
        FileReader filereader = new FileReader(f);
        // create csvReader object passing
        // file reader as a parameter
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                                .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
        String[] nextRecord;
  
        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
            for (String cell : nextRecord) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        return null;

    }
    
}
