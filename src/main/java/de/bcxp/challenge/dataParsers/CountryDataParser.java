package de.bcxp.challenge.dataParsers;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import de.bcxp.challenge.models.ReducedCountry;

public class CountryDataParser implements CSVBeanDataParser<ReducedCountry>{
    private char seperator;
    Reader reader;

    public CountryDataParser(Reader reader) {
        this.reader = reader;
        this.seperator = ';';
    }
    @Override
    public List<ReducedCountry> access(){
        CsvToBean<ReducedCountry> toBean = new CsvToBeanBuilder<ReducedCountry>(this.reader)
                .withSeparator(getSeperator()).withType(ReducedCountry.class)
                .withVerifier(new PopulationAndAreaPositiveBeanVerifier()).build();

        return toBean.parse();
    }

    public Reader getReader() {
        return reader;
    }

    public char getSeperator() {
        return seperator;
    }
    
}
