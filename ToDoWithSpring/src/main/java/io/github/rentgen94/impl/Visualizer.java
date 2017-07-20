package io.github.rentgen94.impl;

import io.github.rentgen94.interfaces.Reader;

/**
 * Created by Let's_rock on 19.07.2017.
 */
public class Visualizer {
    Reader reader;

    public Visualizer(Reader reader) {
        this.reader = reader;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void show() {
        System.out.printf(String.valueOf(reader.read()));
    }
}
