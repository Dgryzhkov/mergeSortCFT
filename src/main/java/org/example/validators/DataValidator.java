package org.example.validators;

import org.example.options.params_app.TypeSort;

/**
 * @Author Dgryzhkov
 */
public class DataValidator{

    public static boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static <T extends Comparable<T>> boolean isCorrectOrderData(TypeSort typeSort, T prev, T next){
        if (prev == null){
            return true;
        }

        if (typeSort == TypeSort.DESC && prev.compareTo(next) >= 0){
            return true;
        } else if (typeSort == TypeSort.ASC && prev.compareTo(next) <= 0){
            return true;
        } else {
            return false;
        }

    }


}
