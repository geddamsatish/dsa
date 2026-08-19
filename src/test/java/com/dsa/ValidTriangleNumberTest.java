package com.dsa;

import com.dsa.twopointers.ValidTriangleNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidTriangleNumberTest {

    @Test
    public void testExample1() {
        int[] nums = {2, 2, 3, 4};
        assertEquals(3, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {4, 2, 3, 4};
        assertEquals(4, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testMinimumLength() {
        int[] nums = {1, 2, 3};
        assertEquals(0, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testValidTriangle() {
        int[] nums = {2, 2, 3};
        assertEquals(1, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testAllSameSides() {
        int[] nums = {5, 5, 5, 5};
        assertEquals(4, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testWithZeros() {
        int[] nums = {0, 0, 1, 2, 3};
        assertEquals(0, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {5};
        assertEquals(0, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testTwoElements() {
        int[] nums = {3, 4};
        assertEquals(0, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0};
        assertEquals(0, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {100, 200, 300, 400};
        assertEquals(1, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testMixedValues() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        assertEquals(5, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testIncreasingSequence() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(3, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testDuplicatesWithInvalidTriangle() {
        int[] nums = {1, 1, 100};
        assertEquals(0, ValidTriangleNumber.triangleNumber(nums));
    }

    @Test
    public void testSmallValidValues() {
        int[] nums = {2, 3, 4, 5, 6};
        assertEquals(7, ValidTriangleNumber.triangleNumber(nums));
    }
}
