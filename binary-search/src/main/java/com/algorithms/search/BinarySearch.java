package com.algorithms.search;

import java.util.Collections;
import java.util.List;

public class BinarySearch {
    private List<Integer> data;
    private int steps = 0;

    public BinarySearch(List<Integer> data) {
        this.data = data;
        Collections.sort(this.data);
    }

    public boolean process(int number) {
        int low = 0;
        int high = data.size()-1;

        while(low <= high) {
            int index = (low + high) / 2;
            int guess = data.get(index);
            steps++;
            if (guess == number) {
                return true;
            } else if (guess > number) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
        return false;
    }

    public int getSteps() {
        return steps;
    }
}
