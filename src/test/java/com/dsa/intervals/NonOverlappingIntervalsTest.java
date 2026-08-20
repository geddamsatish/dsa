package com.dsa.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {

    private NonOverlappingIntervals solution;

    @BeforeEach
    void setUp() {
        solution = new NonOverlappingIntervals();
    }

    @Test
    void testEmptyIntervals() {
        int[][] intervals = {};
        assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testSingleInterval() {
        int[][] intervals = {{0, 30}};
        assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testNoOverlappingIntervals() {
        int[][] intervals = {{0, 30}, {30, 60}, {60, 90}};
        assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testTouchingBoundaryNoRemoval() {
        int[][] intervals = {{1, 2}, {2, 3}};
        assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testAllIdenticalIntervals() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testExample1() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testExample2() {
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testComplexOverlap() {
        int[][] intervals = {{1, 100}, {11, 22}, {31, 44}, {5, 19}};
        assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testNestedIntervals() {
        int[][] intervals = {{0, 10}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        assertEquals(1, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testSortingMatters() {
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}};
        assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testLargeNumbers() {
        int[][] intervals = {{0, 100000}, {50000, 75000}};
        assertEquals(1, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testNegativeValues() {
        int[][] intervals = {{-5, -2}, {-3, 0}, {1, 5}};
        assertEquals(1, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testReverseOrderIntervals() {
        int[][] intervals = {{5, 10}, {0, 5}, {2, 7}};
        assertEquals(1, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testSinglePointIntervals() {
        int[][] intervals = {{5, 5}, {5, 5}, {5, 5}};
        assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testAlternatingOverlap() {
        int[][] intervals = {{1, 2}, {3, 4}, {2, 3}, {5, 6}};
        assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void testTwoIntervalsChainingOverlap() {
        int[][] intervals = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        assertEquals(7, solution.eraseOverlapIntervals(intervals));
    }
}
