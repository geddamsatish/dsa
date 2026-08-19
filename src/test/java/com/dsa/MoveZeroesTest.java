package com.dsa;

import com.dsa.twopointers.MoveZeroes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MoveZeroesTest {

    @Test
    public void testExample1() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testExample2() {
        int[] nums = {0};
        int[] expected = {0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testNoZeros() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0};
        int[] expected = {0, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testSingleNonZero() {
        int[] nums = {5};
        int[] expected = {5};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testZeroAtEnd() {
        int[] nums = {1, 2, 3, 0};
        int[] expected = {1, 2, 3, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testZeroAtBeginning() {
        int[] nums = {0, 1, 2, 3};
        int[] expected = {1, 2, 3, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMultipleZeros() {
        int[] nums = {0, 0, 1};
        int[] expected = {1, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testAlternatingZeros() {
        int[] nums = {0, 1, 0, 2, 0, 3};
        int[] expected = {1, 2, 3, 0, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums = {0, -1, 0, -5, 12};
        int[] expected = {-1, -5, 12, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMixedPositiveNegativeZero() {
        int[] nums = {0, 1, -2, 0, 3, -4, 0, 5};
        int[] expected = {1, -2, 3, -4, 5, 0, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testTwoElements() {
        int[] nums = {0, 1};
        int[] expected = {1, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testTwoElementsReverse() {
        int[] nums = {1, 0};
        int[] expected = {1, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testLargeArray() {
        int[] nums = {0, 1, 2, 0, 3, 4, 5, 0, 6, 7, 8, 9};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRelativeOrderPreserved() {
        int[] nums = {0, 5, 0, 3, 0, 8, 0, 1};
        int[] expected = {5, 3, 8, 1, 0, 0, 0, 0};
        MoveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
        // Verify that non-zero elements appear in the same order
        assertEquals(5, nums[0]);
        assertEquals(3, nums[1]);
        assertEquals(8, nums[2]);
        assertEquals(1, nums[3]);
    }
}
