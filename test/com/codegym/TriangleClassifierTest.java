package com.codegym;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class) // làm quen với cách test Parameterized
public class TriangleClassifierTest {
    @Parameterized.Parameters
    public static Collection<Object[]> triangleClassify() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1, TriangleClassifier.EQUILATERAL_TRIANGLE},
                {4, 6, 9, TriangleClassifier.NORMAL_TRIANGLE},
                {3, 4, 5, TriangleClassifier.RIGHT_TRIANGLE},
                {3, 5, 4, TriangleClassifier.RIGHT_TRIANGLE},
                {0, 10, 0, TriangleClassifier.NOT_TRIANGLE},
                {2, 2, 3, TriangleClassifier.ISOSCELES_TRIANGLE}
        });
    }

    private double side1;
    private double side2;
    private double side3;
    private String expectedResult;
    private TriangleClassifier triangleClassifier;

    @Before
    public void initialize() {
        triangleClassifier = new TriangleClassifier();
    }

    // constructor
    public TriangleClassifierTest(double side1, double side2, double side3, String expectedResult) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.expectedResult = expectedResult;
    }

    @Test
    public void parameterizedTest() {
        String actualResult = triangleClassifier.getTriangleClass(side1, side2, side3);
        System.out.printf("%f %f %f  | %s\n", side1, side2, side3, actualResult);
        assertEquals(expectedResult, actualResult);
    }
}