package com.algorithms.sort;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class SelectionSortTest {
    @Rule
    public TestName name = new TestName();
    private static int testCounter = 0;
    private long startTestTime;
    private long stopTestTime;
    private Sort selectionSort = new SelectionSort();

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
        List<Integer> unsorted = Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 4, 5, 6, 7, 9, 10});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void testDescendingSort() {
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7}));

        List<Integer> sorted = selectionSort.descending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{10, 9, 7, 6, 5, 4, 2, 1});

        Assert.assertThat(sorted, is(expected));
    }

    @Test(expected = NullPointerException.class)
    public void testNullInputSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{null});

        List<Integer> sorted = selectionSort.ascending(unsorted);
    }

    @Test
    public void testEmptyInputSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void testOneInputItemSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{1});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{1});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void test122OrderSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{1, 2, 2});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void test1222OrderSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{1, 2, 2, 2});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void test22OrderSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{2, 2});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{2});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void test222OrderSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{2, 2, 2});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{2});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void testSortedSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        Assert.assertThat(sorted, is(expected));
    }

    @Test
    public void testReverseSortedSort() {
        List<Integer> unsorted = Arrays.asList(new Integer[]{5, 4, 3, 2, 1});

        List<Integer> sorted = selectionSort.ascending(unsorted);
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        Assert.assertThat(sorted, is(expected));
    }

}
