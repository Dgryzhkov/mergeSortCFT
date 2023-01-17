package org.example.command_line;

import org.example.options.Options;

/**
 * @Author Dgryzhkov
 */
public interface ParseUserInput {
    Options parseInput(String[] args);
}
