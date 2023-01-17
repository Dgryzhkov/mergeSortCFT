package org.example.merge;

import org.example.exceptions.IncorrectlySortedFileException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

/**
 * @Author Dgryzhkov
 */
public class MergeFiles<T extends Comparable<T>> {
    ReadersQueue<T> readersQueue;

    public MergeFiles(ReadersQueue<T> readersQueue){
        this.readersQueue = readersQueue;
    }

    public void mergeSortedFiles(File output){

        try (BufferedWriter outputBufferedWriter = new BufferedWriter(new FileWriter(output))) {
            while (!readersQueue.isEmpty()) {

                try {
                    Optional<T> optionalElement = readersQueue.getMinMaxElement();
                    if (optionalElement.isPresent()){
                        T minMaxElement = optionalElement.get();
                        //System.out.println(minMaxElement);
                        outputBufferedWriter.write(minMaxElement.toString() + System.lineSeparator()); //int
                        readersQueue.setPreviousLineInFile(minMaxElement);
                    }
                } catch (IncorrectlySortedFileException e) {
                    System.out.println(e.getMessage() + e.getLine());

                }

            }

        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
