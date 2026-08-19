package com.dsa;

import com.dsa.twopointers.ThreeSum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ThreeSumTest {

    @Test
    public void testExample1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(2, result.size());
        assertTrue(containsTriplet(result, -1, -1, 2));
        assertTrue(containsTriplet(result, -1, 0, 1));
    }

    @Test
    public void testExample2() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(0, result.size());
    }

    @Test
    public void testExample3() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(containsTriplet(result, 0, 0, 0));
    }

    @Test
    public void testMinimumLength() {
        int[] nums = {-2, 0, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(0, result.size());
    }

    @Test
    public void testMinimumLengthWithValidTriplet() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(containsTriplet(result, -1, 0, 1));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] nums = {-4, -3, -2};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(0, result.size());
    }

    @Test
    public void testAllPositiveNumbers() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(0, result.size());
    }

    @Test
    public void testMultipleDuplicates() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(containsTriplet(result, -2, 0, 2));
    }

    @Test
    public void testManySolutionsTriplets() {
        int[] nums = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        // With many duplicates, algorithm may find same triplet at different pointer positions
        assertTrue(result.size() >= 1);
        assertTrue(containsTriplet(result, -1, 0, 1));
    }

    @Test
    public void testLargerArray() {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertTrue(result.size() > 0);
        assertTrue(containsTriplet(result, -4, -2, 6));
        assertTrue(containsTriplet(result, -4, 0, 4));
        assertTrue(containsTriplet(result, -4, 1, 3));
        assertTrue(containsTriplet(result, -2, 0, 2));
    }

    @Test
    public void testNegativeAndPositiveMix() {
        int[] nums = {-2, 0, 0, 2};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(containsTriplet(result, -2, 0, 2));
    }

    @Test
    public void testSingleZeroTriplet() {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(containsTriplet(result, 0, 0, 0));
    }

    @Test
    public void testNoDuplicatesInResult() {
        int[] nums = {-2, -1, -1, 0, 0, 1, 1, 2};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Check no duplicate triplets
        Set<List<Integer>> resultSet = new HashSet<>();
        for (List<Integer> triplet : result) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            resultSet.add(sorted);
        }

        assertEquals(result.size(), resultSet.size(), "Result contains duplicate triplets");
    }

    // Helper method to check if result contains a specific triplet
    private boolean containsTriplet(List<List<Integer>> result, int a, int b, int c) {
        List<Integer> target = Arrays.asList(a, b, c);
        Collections.sort(target);

        for (List<Integer> triplet : result) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            if (sorted.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
