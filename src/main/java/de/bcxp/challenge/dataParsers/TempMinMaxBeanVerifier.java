package de.bcxp.challenge.dataParsers;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

import de.bcxp.challenge.models.ReducedWeatherInformation;

public class TempMinMaxBeanVerifier implements BeanVerifier<ReducedWeatherInformation> {

    /**
     * This Validator checks if the maximal temperature is higher than or equal to the minimal temperature.
     */
    @Override
    public boolean verifyBean(ReducedWeatherInformation bean) throws CsvConstraintViolationException {
        if (bean.getMxT() < bean.getMnT()) {
            throw new CsvConstraintViolationException(
                    "Maximaltemperatur darf nicht kleiner sein als Minimaltemperatur.");
        }
        return true;
    }
}
