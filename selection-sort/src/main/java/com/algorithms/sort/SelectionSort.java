package com.algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class SelectionSort {

    List<Integer> ascending(final List<Integer> input) {
        return sort(input, Order.ASC);
    }

    List<Integer> descending(final List<Integer> input) {
        return sort(input, Order.DESC);
    }

    private static List<Integer> sort(final List<Integer> input, Order type) {
        List<Integer> inputItems = new ArrayList<>(input);
        List<Integer> output = new ArrayList<>();
        int number = 0;
        while(notEmpty(inputItems)) {
            switch(type) {
                case ASC:
                    number = findMin(inputItems);
                    break;
                case DESC:
                    number = findMax(inputItems);
                    break;
            }
            output.add(number);
            inputItems.remove(inputItems.indexOf(number));
        }
        return output;
    }

    private static int findMin(List<Integer> input) {
        return input.stream()
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
    }

    private static int findMax(List<Integer> input) {
        return input.stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
    }

    private static boolean notEmpty(List<Integer> input) {
        return !input.isEmpty();
    }

    private enum Order {
        ASC,
        DESC
    }
}
