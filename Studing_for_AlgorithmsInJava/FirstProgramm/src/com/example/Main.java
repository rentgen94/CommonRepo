package com.example;

import java.util.LinkedList;

/**
 * Created by Western-Co on 27.11.2016.
 * This class used for testing many exercise from book: Algorithms in JAVA
 * @author Egor Shchurbin
 * @version 1.0
 */
public class Main{

    /**
     * This class for testing lambda-expressions
     */
    public static class Test {
        public double n = 10.0;
    }

    /**
     * This standard main thread in our project
     * @param args Standard parameters in psvm
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Test test = new Test();
        final int[] local = {10};
        MyNumber num = (n) -> ++local[0];
        System.out.println(num.getValue(100));
        System.out.println(local[0]);
    }
}
