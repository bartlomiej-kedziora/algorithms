package com.algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SelectionSort {
    private int findMin(List<Integer> input) {
        return input.stream()
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
    }

    private int findMax(List<Integer> input) {
        return input.stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public List<Integer> ascending(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        while(input.size() > 0) {
                int min = findMin(input);
                output.add(min);
                input.remove(input.indexOf(min));
        }
        return output;
    }

    public List<Integer> descending(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        while(input.size() > 0) {
            int max = findMax(input);
            output.add(max);
            input.remove(input.indexOf(max));
        }
        return output;
    }
}
