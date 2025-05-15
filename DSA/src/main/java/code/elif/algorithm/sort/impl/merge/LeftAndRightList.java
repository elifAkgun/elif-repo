package code.elif.algorithm.sort.impl.merge;

import java.util.List;

public record LeftAndRightList<T>(
        List<T> right, List<T> left) {
}
