package code.elif.algorithm.search.impl;

import code.elif.algorithm.search.Search;

import java.util.List;

public class RecursiveBinarySearch<T extends Comparable<T>> {

    public boolean find(T target, List<T> list) {
        if (list == null || list.size() == 0) {
            return false;
        } else {
            int midPoint = list.size() / 2;
            if (list.get(midPoint).equals(target)) {
                return true;
            } else {
                if (list.get(midPoint).compareTo(target) > 0) {
                    return find(target, list.subList(0, midPoint));
                } else
                    return find(target, list.subList(midPoint + 1, list.size()));
            }
        }
    }
}
