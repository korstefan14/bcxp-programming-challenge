package de.bcxp.challenge.dataReaders;

/**
 * This class tests the LocalFileReaderFactory
 * It receives some tests from CSVBeanDataParserContract and DataParserContract
 */
public class LocalFileReaderFactoryTest implements ReaderFactoryTest {

    @Override
    public ReaderFactory getInstance() {
        return new LocalFileReaderFactory();
    }

}
