package org.example.options.comparators;

import org.example.merge.ReaderWithFile;
import java.util.Comparator;
import java.util.Map;

/**
 * @Author Dgryzhkov
 */
public class SortASC<K extends Comparable<K>>  implements Comparator<Map.Entry<K, ReaderWithFile>> {
    @Override
    public int compare(Map.Entry<K, ReaderWithFile> obj1, Map.Entry<K, ReaderWithFile> obj2) {
        return obj1.getKey().compareTo(obj2.getKey());
    }

}
