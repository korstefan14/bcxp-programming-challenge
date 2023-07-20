package de.bcxp.challenge.dataReaders;

import java.io.FileNotFoundException;
import java.io.Reader;

public interface ReaderFactory {
    /**
     * @param location The Location of the resource that should be read
     * @return A java.io.reader pointing to the resource
     * @throws FileNotFoundException if the resource could not be found
     */
    public Reader acquireReader(String location) throws FileNotFoundException;
}
