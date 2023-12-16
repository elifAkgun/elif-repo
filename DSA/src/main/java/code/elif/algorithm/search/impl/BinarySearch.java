package code.elif.algorithm.search.impl;

import code.elif.algorithm.search.Search;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {

    @Override
    public int find(T target, List<T> list) {
        if (list != null) {
            int leftIndex = 0;
            int rightIndex = list.size();

            while (rightIndex > leftIndex) {
                int index = (leftIndex + rightIndex) / 2;
                if (list.get(index).compareTo(target) == 0) {
                    return index;
                } else if (list.get(index).compareTo(target) < 0) {
                    leftIndex = index + 1;
                } else {
                    rightIndex = index - 1;
                }
            }
        }
        return -1;
    }
}
