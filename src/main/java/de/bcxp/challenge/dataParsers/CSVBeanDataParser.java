package de.bcxp.challenge.dataParsers;


public interface CSVBeanDataParser<U> extends DataParser<U>{

    /**
     * @return The seperator that is used in the CSV file
     */
    char getSeperator();


    
}
