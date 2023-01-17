package org.example.exceptions;

/**
 * @Author Dgryzhkov
 */
public class IncorrectlySortedFileException extends Exception{
    private final String line;
    public IncorrectlySortedFileException(String message, String line){
        super(message);
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
