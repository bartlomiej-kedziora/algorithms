package com.algorithms.sort;

import java.util.*;

class SelectionSort implements Sort {
    private static final int ZERO = 0;

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
        int lastAddedNumber = ZERO;

        if(notEmpty(inputItems)) {
            lastAddedNumber = findMin(inputItems,order);
            output.add(lastAddedNumber);
            inputItems.remove(inputItems.indexOf(lastAddedNumber));
        }

        while(notEmpty(inputItems)) {
            inputNumber = findMin(inputItems,order);
            if(inputNumber != lastAddedNumber) {
                output.add(inputNumber);
            }
            lastAddedNumber = inputNumber;
            inputItems.remove(inputItems.indexOf(inputNumber));
        }
        return output;
    }

    private static int findMin(List<Integer> input, Order order) {
        Comparator<Integer> comparator = getComparator(order);
        return input.stream()
                .min(comparator)
                .orElseThrow(NoSuchElementException::new);
    }

    private static boolean notEmpty(List<Integer> input) {
        return !input.isEmpty();
    }

    private static Comparator<Integer> getComparator(Order order) {
        switch (order) {
            case ASC :
                return Comparator.naturalOrder();
            case DESC:
                return Comparator.reverseOrder();
                default:
                    throw new AssertionError("Incorrect sort order");
        }
    }

    private enum Order {
        ASC,
        DESC
    }
}
