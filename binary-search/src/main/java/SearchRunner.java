import com.algorithms.search.BinarySearch;

import java.util.Arrays;
import java.util.List;

public class SearchRunner {
    public static void main(String[] args) {
        Integer[] inputData = new Integer[]{10, 5, 4, 9, 1, 6, 2, 7};
        int searchNumber = 7;
        List<Integer> data = Arrays.asList(inputData);
        int sizeOfList = data.size();
        BinarySearch binarySearch = new BinarySearch(data);

        long startTestTime = System.nanoTime();
        boolean exist = binarySearch.process(searchNumber);
        long stopTestTime = System.nanoTime();

        int steps = binarySearch.getSteps();

        System.out.println("Binary search algorithm tests seeking number: "
                + searchNumber + " in: " + Arrays.toString(inputData));

        if(exist) {
            System.out.println("Searched number has been found in: " + steps
                    + " steps of " + sizeOfList + " items and taken: "
                    + (stopTestTime - startTestTime) + "ns.");
        }
        else {
            System.out.println("Searched number not exists");
        }
    }
}
