package storage;

import util.Config;

import static org.junit.Assert.*;

public class SqlStorageTest extends AbstractStorageTest{

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}