package de.bcxp.challenge.dataReaders;

import java.io.FileNotFoundException;
import java.io.Reader;

public interface ReaderFactory {
    public Reader acquireReader(String location) throws FileNotFoundException;
}
