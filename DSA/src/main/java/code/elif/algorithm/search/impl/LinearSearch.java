package code.elif.algorithm.search.impl;

import code.elif.algorithm.search.Search;

import java.util.List;

public class LinearSearch<T> implements Search<T> {

    /**
     * Returns the position of the target if found, else return -1
     * @param target
     * @return
     */
    @Override
    public int find(T target, List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target)
                return i;
        }
        return -1;
    }
}
