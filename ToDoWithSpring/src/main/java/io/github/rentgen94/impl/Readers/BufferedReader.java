package io.github.rentgen94.impl.Readers;

import io.github.rentgen94.interfaces.Reader;

/**
 * Created by Let's_rock on 19.07.2017.
 */
public class BufferedReader<T> implements Reader {
    @Override
    public T read() {
        return (T) "Hello World!";
    }
}
