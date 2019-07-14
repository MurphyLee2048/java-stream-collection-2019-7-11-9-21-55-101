package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return IntStream.rangeClosed(Math.min(left, right), Math.max(left, right))
                .boxed()  // IntStream => stream, stream才有collect方法
                .sorted(left > right ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return IntStream.rangeClosed(Math.min(left, right), Math.max(left, right))
                .filter( x -> x % 2 == 0)
                .boxed()
                .sorted(left > right ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        // Here, the stream is reduced to a level where it is left with only the last element.
        // If the stream is empty it will return a null value.
        return Arrays.stream(array).boxed().
                reduce((first, second) -> second)
                .orElse(null);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
