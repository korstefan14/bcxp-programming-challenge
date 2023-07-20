package de.bcxp.challenge.dataParsers;

import java.math.BigDecimal;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

import de.bcxp.challenge.models.ReducedCountry;

public class PopulationAndAreaPositiveBeanVerifier implements BeanVerifier<ReducedCountry>{

    @Override
    public boolean verifyBean(ReducedCountry bean) throws CsvConstraintViolationException {
        if (bean.getArea()<1 || bean.getPopulation()<1) {
            throw new CsvConstraintViolationException(
                    "Gebiet und Bevölkerungszahl aller Länder müssen positiv sein.");
        }
        return true;
    }
    
}
