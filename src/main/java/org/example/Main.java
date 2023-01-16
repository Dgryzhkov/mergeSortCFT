package org.example;

import org.example.command_line.ParseUserInputImpl;

/**
 * @Author Dgryzhkov
 */
public class Main {
    public static void main(String[] args) {
        ParseUserInputImpl parseUserInputImpl = new ParseUserInputImpl();
        parseUserInputImpl.parseInput(args);
    }
}
