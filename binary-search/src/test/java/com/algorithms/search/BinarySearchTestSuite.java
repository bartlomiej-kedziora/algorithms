package com.algorithms.search;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTestSuite {
    @Rule
    public TestName name = new TestName();
    private static int testCounter = 0;
    private long startTestTime;
    private long stopTestTime;
    private int steps;
    private int sizeOfList;


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
        System.out.println("    Test has finished and taken: " + (stopTestTime - startTestTime) + "ns. [" + steps + "/" + sizeOfList + " (steps/numbers)]");
    }

    @Test
    public void testSearchNumberGreaterThanMiddleIndex() {
        //Given
        List<Integer> data = Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7});
        sizeOfList = data.size();
        BinarySearch binarySearch = new BinarySearch(data);

        //When
        boolean exist = binarySearch.process(7);
        steps = binarySearch.getSteps();

        //Then
        Assert.assertTrue(exist);
        Assert.assertEquals(2, steps);
    }

    @Test
    public void testSearchNumberLowerThanMiddleIndex() {
        //Given
        List<Integer> data = Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7});
        sizeOfList = data.size();
        BinarySearch binarySearch = new BinarySearch(data);

        //When
        boolean exist = binarySearch.process(1);
        steps = binarySearch.getSteps();

        //Then
        Assert.assertTrue(exist);
        Assert.assertEquals(3, steps);
    }

    @Test
    public void testSearchNumberThatNoExists() {
        //Given
        List<Integer> data = Arrays.asList(new Integer[]{10, 5, 4, 9, 1, 6, 2, 7});
        sizeOfList = data.size();
        BinarySearch binarySearch = new BinarySearch(data);

        //When
        boolean exist = binarySearch.process(0);
        steps = binarySearch.getSteps();

        //Then
        Assert.assertFalse(exist);
        Assert.assertEquals(3, steps);
    }


}
