package ru.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Let's_rock on 14.07.2017.
 */
public class Test {
    private final static Logger log = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        log.info("in logger");
        System.out.println("Hello");
    }
}
