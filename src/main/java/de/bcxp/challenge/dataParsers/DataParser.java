package de.bcxp.challenge.dataParsers;

import java.io.Reader;
import java.util.List;


public interface DataParser<T> {
    List<T> access();
    Reader getReader();
}
