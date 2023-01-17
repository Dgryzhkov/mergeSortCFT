package org.example.options.comparators;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Map;

/**
 * @Author Dgryzhkov
 */
public class SortASC<K extends Comparable<K>>  implements Comparator<Map.Entry<K, BufferedReader>> {
    @Override
    public int compare(Map.Entry<K, BufferedReader> obj1, Map.Entry<K, BufferedReader> obj2) {
        return obj1.getKey().compareTo(obj2.getKey());
    }

}