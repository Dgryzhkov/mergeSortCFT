package org.example.command_line;

import org.example.command_line.help.Help;
import org.example.options.params_input.DataType;
import org.example.options.params_input.TypeSort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dgryzhkov
 */
public class ParseUserInputImpl {
    private static final int REQUIRED_NUMBER_OF_ARGS = 3;

    @Override
    public Options parseInput(String[] inputArgs) {
        if (inputArgs.length < 1) {
            Help.displayCommandHelp();
            System.exit(0);
        }

        if ((inputArgs.length < REQUIRED_NUMBER_OF_ARGS) && (inputArgs[0].equals("-h") || inputArgs[0].equals("--help"))) {
            Help.displayCommandHelp();
            throw new IllegalArgumentException("Введены не все обязательные параметры! Пожалуйста, повторите ввод или воспользуйтесь справкой.");
        }

        List<File> inputFiles = new ArrayList<>();
        DataType dataType = DataType.NOT_INIT;
        TypeSort typeSort = TypeSort.ASC;
        File outputFile = null;

        for (int param = 1; param < inputArgs.length; param++) {
            if (inputArgs[param].equals("-a") || inputArgs[param].equals("--asc")) {
                typeSort = TypeSort.ASC;
            } else if (inputArgs[param].equals("-d") || inputArgs[param].equals("--desc")) {
                typeSort = TypeSort.DESC;
            } else if (inputArgs[param].equals("-s") || inputArgs[param].equals("--string")) {
                dataType = DataType.STRING;
            } else if (inputArgs[param].equals("-i") || inputArgs[param].equals("--integer")) {
                dataType = DataType.INTEGER;
            } else if (inputArgs[param].equals("-h") || inputArgs[param].equals("--help")) {
                Help.displayHelp();
                System.exit(0);
            } else {

                if (outputFile == null) {
                    outputFile = new File(inputArgs[param]);
                } else {
                    inputFiles.add(new File(inputArgs[param]));
                }

            }
        }

        return new OptionsImpl(inputFiles, dataType, typeSort, outputFile);

    }


    public static void checkUserInput() {

    }
}