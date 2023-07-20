package de.bcxp.challenge.dataParsers;

import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import de.bcxp.challenge.models.ReducedWeatherInformation;

public class WeatherDataParser implements CSVBeanDataParser<ReducedWeatherInformation> {
    private char seperator;
    Reader reader;

    public Reader getReader() {
        return reader;
    }

    public char getSeperator() {
        return seperator;
    }

    public WeatherDataParser(Reader reader) {
        this.reader = reader;
        this.seperator = ',';
    }

    @Override
    public List<ReducedWeatherInformation> access() {
        CsvToBean<ReducedWeatherInformation> toBean = new CsvToBeanBuilder<ReducedWeatherInformation>(this.reader)
                .withSeparator(getSeperator()).withType(ReducedWeatherInformation.class)
                .withVerifier(new TempMinMaxBeanVerifier()).build();

        return toBean.parse();
    }

}
