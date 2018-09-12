package com.algorithms.sort;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class SelectionSortTestSuite {
    @Rule
    public TestName name = new TestName();
    private static int testCounter = 0;
    private long startTestTime;
    private long stopTestTime;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void before() {
        testCounter++;
        startTestTime = System.nanoTime();
        System.out.println("  Preparing to execute test #" + testCounter);
        System.out.println("    Currently we're testing: " + name.getMethodName() + " method");
    }

    @After
    public void after() {
        stopTestTime = System.nanoTime();
        System.out.println("    Test has finished and taken: " + (stopTestTime - startTestTime) + "ns.");
    }

    @Test
    public void testAscendingSort() {
        //Given
        SelectionSort selectionSort = new SelectionSort();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7}));
        List<Integer> sorted = new ArrayList<>();

        //When
        sorted.addAll(selectionSort.ascending(unsorted));
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 4, 5, 6, 7, 9, 10});

        //Then
        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void testDescendingSort() {
        //Given
        SelectionSort selectionSort = new SelectionSort();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7}));
        List<Integer> sorted = new ArrayList<>();

        //When
        sorted.addAll(selectionSort.descending(unsorted));
        List<Integer> expected = Arrays.asList(new Integer[]{10, 9, 7, 6, 5, 4, 2, 1});

        //Then
        Assert.assertThat(sorted, is(expected));
    }
}
