package org.example.merge;

import org.example.exceptions.IncorrectlySortedFileException;
import org.example.options.Options;
import org.example.options.comparators.SortASC;
import org.example.options.comparators.SortDESC;
import org.example.options.params_input.TypeSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Author Dgryzhkov
 */
public abstract class ReadersQueue<K extends Comparable<K>> implements TypeValidator {
    private final Queue<Map.Entry<K, BufferedReader>> linesReadersQueue;
    private final Options options;

    public ReadersQueue(Options options) throws IOException {
        this.options = options;

        Comparator<Map.Entry<K, BufferedReader>> sortComparator =
                (this.options.getTypeSort() == TypeSort.ASC) ? new SortASC<>() : new SortDESC<>();

        this.linesReadersQueue = new PriorityQueue<>(this.options.getInputFiles().size(), sortComparator);
        this.getInitQueue();
    }

    private void getInitQueue() throws IOException {
        linesReadersQueue.clear();
        List<File> inputFiles = options.getInputFiles();
        List<File> filterInputFiles = DataValidator.filterNotFoundFiles(inputFiles);

        for (File file : filterInputFiles){
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            K firstLine = convert(buffReader.readLine());
            this.add(buffReader, firstLine);

        }
    }

    private void add(BufferedReader buffReader, K line) throws IOException {
        if (line != null) {


            linesReadersQueue.offer(new AbstractMap.SimpleImmutableEntry<>(line, buffReader));

        } else {
            buffReader.close();
        }

    }

    public K getMinMaxElement() throws IOException, IncorrectlySortedFileException {
        Map.Entry<K, BufferedReader> elemReader = linesReadersQueue.poll();
        assert elemReader != null;
        BufferedReader buffReader = elemReader.getValue();
        K line = elemReader.getKey();
        K nextLine = convert(buffReader.readLine());
        this.add(buffReader, nextLine);

        if (TypeValidator.isCorrectOrderData(options.getTypeSort(), line, nextLine)){
            return nextLine;
        } else {
            throw new IncorrectlySortedFileException("Нарушен порядок сортировки, данная строка будет пропущена: ", nextLine.toString());
        }

    }


    public K getElement() {
        assert linesReadersQueue.peek() != null;
        return linesReadersQueue.peek().getKey();
    }

    private BufferedReader getBufferReader() {
        assert linesReadersQueue.peek() != null;
        return linesReadersQueue.peek().getValue();
    }

    public boolean isEmpty() {
        return linesReadersQueue.isEmpty();
    }

    protected abstract K convert(String string) throws NumberFormatException;


}