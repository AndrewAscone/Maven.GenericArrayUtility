package com.zipcodewilmington.arrayutility;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    E[] genericArray;

    public ArrayUtility(E[] inputArray) {
        this.genericArray = inputArray;
    }

    public <E> Integer getNumberOfOccurrences(E valueToEvaluate){
        int count = 0;
        for(int i = 0; i < genericArray.length; i++){
            if(genericArray[i] == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate){
        int count = 0;
        List<E> combinedArray = new ArrayList<>(arrayToMerge.length + genericArray.length);

        combinedArray.addAll(Arrays.asList(genericArray));
        for(int i = 0; i < arrayToMerge.length; i++){
            combinedArray.add(arrayToMerge[i]);
        }

        for(int i = 0; i < combinedArray.size(); i++){
            if(combinedArray.get(i) == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        List<E> combinedArray = new ArrayList<>(arrayToMerge.length + genericArray.length);

        combinedArray.addAll(Arrays.asList(genericArray));
        for (int i = 0; i < arrayToMerge.length; i++) {
            combinedArray.add(arrayToMerge[i]);
        }

        int currentHigh = 0;
        E mostCommon = null;

        for (int i = 0; i < combinedArray.size(); i++) {
            int count = 0;
            for (int j = 0; j < combinedArray.size(); j++) {
                if (combinedArray.get(i) == combinedArray.get(j)) {
                    count++;
                }
            }
            if (count > currentHigh) {
                currentHigh = count;
                mostCommon = combinedArray.get(i);
            }
        }
        return mostCommon;
    }

    public E[] removeValue(E valueToRemove){
        ArrayList<E> copyList = new ArrayList<>(List.of(genericArray));
        for(int i = 0; i < copyList.size(); i++){
            if(copyList.get(i) == valueToRemove){
                copyList.remove(i);
                i--;
            }
        }

        E[] result = Arrays.copyOf(genericArray, copyList.size());

        for (int i = 0; i < result.length; i++) {
            result[i] = copyList.get(i);
        }

        return result;
    }
}
