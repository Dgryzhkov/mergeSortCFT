package org.example.merge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author Dgryzhkov
 */
public class ReaderWithFile {
    private final File file;
    private final BufferedReader bufferedReader;

    public ReaderWithFile(File file) throws IOException {
        this.file = file;
        bufferedReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
    }

    public File getFile() {
        return file;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}