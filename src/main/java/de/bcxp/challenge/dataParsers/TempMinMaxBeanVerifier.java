package de.bcxp.challenge.dataParsers;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;

import de.bcxp.challenge.models.ReducedWeatherInformation;

public class TempMinMaxBeanVerifier implements BeanVerifier<ReducedWeatherInformation> {

    @Override
    public boolean verifyBean(ReducedWeatherInformation bean) throws CsvConstraintViolationException {
        if (bean.getMxT() < bean.getMnT()) {
            throw new CsvConstraintViolationException(
                    "Maximaltemperatur darf nicht kleiner sein als Minimaltemperatur.");
        }
        return true;
    }
}
