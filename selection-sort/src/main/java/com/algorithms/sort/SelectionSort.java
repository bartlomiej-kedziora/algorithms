package com.algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SelectionSort {

    public List<Integer> ascending(final List<Integer> input) {
        return sort(input, "asc");
    }

    public List<Integer> descending(final List<Integer> input) {
        return sort(input, "desc");
    }

    private static List<Integer> sort(final List<Integer> input, String type) {
        List<Integer> inputItems = new ArrayList<>(input);
        List<Integer> output = new ArrayList<>();
        int number = 0;
        while(inputItems.size() > 0) {
            if(type == "asc") {
                number = findMin(inputItems);
            }
            else {
                number = findMax(inputItems);
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
}
