package com.dsa.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    private MergeIntervals solution;

    @BeforeEach
    void setUp() {
        solution = new MergeIntervals();
    }

    @Test
    void testEmptyIntervals() {
        int[][] intervals = {};
        int[][] expected = {};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testSingleInterval() {
        int[][] intervals = {{1, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testNoOverlappingIntervals() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        int[][] expected = {{1, 2}, {3, 4}, {5, 6}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testMergeExample1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testMergeExample2() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testAllOverlapIntoOne() {
        int[][] intervals = {{1, 4}, {2, 3}, {3, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testReverseOrderIntervals() {
        int[][] intervals = {{5, 7}, {1, 3}, {2, 4}};
        int[][] expected = {{1, 4}, {5, 7}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testNestedIntervals() {
        int[][] intervals = {{1, 10}, {2, 5}, {3, 7}};
        int[][] expected = {{1, 10}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testTouchingBoundariesMerge() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}};
        int[][] expected = {{1, 4}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testAllIdenticalIntervals() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        int[][] expected = {{1, 2}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testComplexMerging() {
        int[][] intervals = {{1, 3}, {0, 0}, {2, 6}, {8, 9}, {8, 9}, {9, 9}};
        int[][] expected = {{0, 0}, {1, 6}, {8, 9}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testLargeNumbers() {
        int[][] intervals = {{0, 100000}, {50000, 75000}};
        int[][] expected = {{0, 100000}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testNegativeValues() {
        int[][] intervals = {{-5, -2}, {-3, 0}, {1, 5}};
        int[][] expected = {{-5, 0}, {1, 5}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testSinglePointIntervals() {
        int[][] intervals = {{1, 1}, {1, 1}, {2, 2}};
        int[][] expected = {{1, 1}, {2, 2}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testMultipleGroupsMerge() {
        int[][] intervals = {{1, 2}, {3, 4}, {1, 3}};
        int[][] expected = {{1, 4}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testPartialOverlaps() {
        int[][] intervals = {{1, 5}, {2, 3}, {4, 6}, {7, 8}};
        int[][] expected = {{1, 6}, {7, 8}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void testLongChainOfMerges() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        int[][] expected = {{1, 6}};
        assertArrayEquals(expected, solution.merge(intervals));
    }
}
