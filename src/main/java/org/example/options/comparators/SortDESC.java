package org.example.options.comparators;

import org.example.merge.ReaderWithFile;
import java.util.Comparator;
import java.util.Map;

/**
 * @Author Dgryzhkov
 */
public class SortDESC<T extends Comparable<T>>  implements  Comparator<Map.Entry<T, ReaderWithFile>>{
    @Override
    public int compare(Map.Entry<T, ReaderWithFile> obj1, Map.Entry<T, ReaderWithFile> obj2) {
        return -obj1.getKey().compareTo(obj2.getKey());
    }
}