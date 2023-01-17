package org.example.options;

import org.example.options.params_input.DataType;
import org.example.options.params_input.TypeSort;

import java.io.File;
import java.util.List;

/**
 * @Author Dgryzhkov
 */
public class Options{
    List<File> inputFiles;
    DataType dataType;
    TypeSort typeSort;
    File output;
    Sorting sortComparator;

    public Options(List<File> inputFiles, DataType dataType, TypeSort typeSort, File output){
        this.inputFiles = inputFiles;
        this.dataType = dataType;
        this.typeSort = typeSort;
        this.output = output;
        this.sortComparator = (this.typeSort == TypeSort.DESC) ? new SortDESC() : new SortASC();

    }

    public List<File> getInputFiles() {
        return inputFiles;
    }

    public DataType getDataType() {
        return dataType;
    }

    public TypeSort getTypeSort() {
        return typeSort;
    }

    public File getOutput() {
        return output;
    }

    public Sorting getSortComparator() {
        return sortComparator;
    }

    public void setInputFiles(List<File> inputFiles) {
        this.inputFiles = inputFiles;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setTypeSort(TypeSort typeSort) {
        this.typeSort = typeSort;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    public void setSortComparator(Sorting sortComparator) {
        this.sortComparator = sortComparator;
    }
}
