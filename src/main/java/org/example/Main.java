package org.example;

import org.example.command_line.ParseCommandLine;
import org.example.command_line.ParseCommandLineImpl;
import org.example.exceptions.EmptyLineException;
import org.example.merge.MergeFiles;
import org.example.merge.ReadersQueue;
import org.example.options.Options;
import org.example.options.params_app.DataType;
import org.example.validators.DataValidator;

/**
 * @Author Dgryzhkov
 */
public class Main {
    public static void main(String[] args){
        ParseCommandLine parseCommandLine = new ParseCommandLineImpl();
        Options options = parseCommandLine.parse(args);

        if (options.getDataType() == DataType.INTEGER){
            ReadersQueue<Integer> readersQueueInt = readersQueueForIntegers(options);
            MergeFiles<Integer> mergeFiles = new MergeFiles<>(readersQueueInt);
            mergeFiles.mergeSortedFiles(options.getOutput());
        } else {
            ReadersQueue<String> readersQueueStr = readersQueueForStrings(options);
            MergeFiles<String> mergeFiles = new MergeFiles<>(readersQueueStr);
            mergeFiles.mergeSortedFiles(options.getOutput());
        }
    }

    private static ReadersQueue<Integer> readersQueueForIntegers(Options options){
        return new ReadersQueue<>(options) {
            @Override
            protected Integer convert(String string, String fileName) throws NumberFormatException {
                if (DataValidator.isInteger(string)) {
                    return Integer.valueOf(string);
                }
                throw new NumberFormatException(String.format("Файл %s: Не удалось преобразовать строку %s в число, данная строка будет пропущена", fileName, string));
            }
        };
    }

    private static ReadersQueue<String> readersQueueForStrings(Options options){
        return new ReadersQueue<>(options) {
            @Override
            protected String convert(String string, String fileName) throws EmptyLineException {
                if (!string.isBlank()) {
                    return string.trim();
                }
                throw new EmptyLineException(String.format("Файл %s: Пустая строка в файле будет пропущена.", fileName));
            }
        };
    }
}
