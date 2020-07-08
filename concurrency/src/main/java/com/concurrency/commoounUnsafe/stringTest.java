package com.concurrency.commoounUnsafe;

public class stringTest {
    private static stringTest ourInstance = new stringTest();

    public static stringTest getInstance() {
        return ourInstance;
    }

    private stringTest() {
    }
}
