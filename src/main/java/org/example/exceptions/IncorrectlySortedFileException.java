package org.example.exceptions;

/**
 * @Author Dgryzhkov
 */
public class IncorrectlySortedFileException extends Exception{
    private final String line;
    private final String fileName;

    public IncorrectlySortedFileException(String message, String line, String fileName){
        super(message);
        this.line = line;
        this.fileName = fileName;
    }

    public String getLine() {
        return line;
    }

    public String getFileName() {
        return fileName;
    }
}

