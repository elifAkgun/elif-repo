package code.elif.algorithm.sort.impl.merge;

import code.elif.algorithm.sort.Sortable;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public List<T> sort(List<T> list) {

        if (list.size() <= 1) {
            return list;
        }

        LeftAndRightList<T> leftAndRightList = splitList(list);
        List<T> left = sort(leftAndRightList.left());
        List<T> right = sort(leftAndRightList.right());

        return merge(left, right);
    }

    private LeftAndRightList<T> splitList(List<T> list) {
        int midPoint = list.size() / 2;
        return new LeftAndRightList<>(list.subList(0, midPoint), list.subList(midPoint, list.size()));
    }

    /**
     * Merges two lists, sorting them in the process
     * @param left part of list
     * @param right part of list
     * @return merged list
     */
    private List<T> merge(List<T> left, List<T> right) {
        List<T> mergedList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                mergedList.add(left.get(i));
                i++;
            } else {
                mergedList.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            mergedList.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            mergedList.add(right.get(j));
            j++;
        }
        return mergedList;
    }
}
