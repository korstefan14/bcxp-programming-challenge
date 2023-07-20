package de.bcxp.challenge.dataReaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class LocalFileReaderFactory implements ReaderFactory{

    @Override
    public Reader acquireReader(String location) throws FileNotFoundException {
        if(location==null) {
            throw new NullPointerException("Location must not be null");
        }
        File f = new File(location);
        return new FileReader(f);
    }
    
}
