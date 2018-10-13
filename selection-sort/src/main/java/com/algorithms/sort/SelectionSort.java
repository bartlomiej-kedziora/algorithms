package com.algorithms.sort;

import java.util.*;
import java.util.function.Function;

class SelectionSort implements Sort {

    public List<Integer> ascending(final List<Integer> input) {
        return sort(input, Order.ASC);
    }

    public List<Integer> descending(final List<Integer> input) {
        return sort(input, Order.DESC);
    }

    private static List<Integer> sort(final List<Integer> input, Order order) {
        List<Integer> inputItems = new ArrayList<>(input);
        List<Integer> output = new ArrayList<>();
        int inputNumber;
        int lastAddedNumber = 0;

        while(notEmpty(inputItems)) {
            inputNumber = findMinOrMax(inputItems,order);
            if(inputNumber != lastAddedNumber) {
                output.add(inputNumber);
            }
            lastAddedNumber = inputNumber;
            inputItems.remove(inputItems.indexOf(inputNumber));
        }
        return output;
    }

    private static int findMinOrMax(List<Integer> input, Order order) {
        Comparator<Integer> comparator = isMinOrMax(order);
        return input.stream()
                .min(comparator)
                .orElseThrow(NoSuchElementException::new);
    }

    private static boolean notEmpty(List<Integer> input) {
        return !input.isEmpty();
    }

    private static Comparator<Integer> isMinOrMax(Order order) {
        if(order.equals(Order.ASC)) {
            return Comparator.naturalOrder();
        }
        return Comparator.reverseOrder();
    }

    private enum Order {
        ASC,
        DESC
    }
}
