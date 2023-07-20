package de.bcxp.challenge.dataReaders;

public class LocalFileReaderFactoryTest implements ReaderFactoryTest{

    @Override
    public ReaderFactory getInstance() {
        return new LocalFileReaderFactory();
    }
    
}
