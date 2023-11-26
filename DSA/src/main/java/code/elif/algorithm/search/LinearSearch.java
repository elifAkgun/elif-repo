package code.elif.algorithm.search;

import java.util.List;

public class LinearSearch<T> implements Search<T> {
    private List<T> list;

    public LinearSearch(List<T> list) {
        this.list = list;
    }

    /**
     * Returns the position of the target if found, else return -1
     * @param target
     * @return
     */
    @Override
    public int find(T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target)
                return i;
        }
        return -1;
    }
}
