package de.bcxp.challenge.dataParsers;

import java.io.Reader;
import java.util.List;

public interface DataParser<T> {

    /**
     * @return The list of data from the file that the parser parses
     *         Relies heavily on the OpenCSV library for actually parsing the data.
     *         I chose this mostly because it allows easy mapping of the data to
     *         beans
     *         and because it allows for easy data validation (see
     *         TempMinMaxBeanVerifier.java)
     */
    List<T> access();

    /**
     * @return The Parser
     */
    Reader getReader();
}
