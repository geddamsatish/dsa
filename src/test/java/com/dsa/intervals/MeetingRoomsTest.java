package com.dsa.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsTest {

    private MeetingRooms solution;

    @BeforeEach
    void setUp() {
        solution = new MeetingRooms();
    }

    @Test
    void testNoMeetings() {
        int[][] intervals = {};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testSingleMeeting() {
        int[][] intervals = {{0, 30}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testNonOverlappingMeetings() {
        int[][] intervals = {{0, 30}, {30, 60}, {60, 90}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testOverlappingMeetings() {
        int[][] intervals = {{0, 30}, {15, 60}};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testOverlappingExample1() {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testExactlyTouchingMeetings() {
        int[][] intervals = {{1, 2}, {2, 3}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testReverseOrderMeetings() {
        int[][] intervals = {{60, 90}, {30, 60}, {0, 30}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testComplexNonOverlapping() {
        int[][] intervals = {{1, 5}, {7, 10}, {12, 15}, {16, 20}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testComplexOverlapping() {
        int[][] intervals = {{1, 5}, {7, 10}, {9, 12}, {16, 20}};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testTwoMeetingsNoOverlap() {
        int[][] intervals = {{0, 10}, {10, 20}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testTwoMeetingsWithOverlap() {
        int[][] intervals = {{0, 15}, {10, 20}};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testNestedMeetings() {
        int[][] intervals = {{0, 100}, {10, 20}};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testIdenticalMeetings() {
        int[][] intervals = {{5, 10}, {5, 10}};
        assertFalse(solution.canAttendMeetings(intervals));
    }

    @Test
    void testLargeMeetingTime() {
        int[][] intervals = {{0, 1000000}, {1000001, 2000000}};
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    void testNegativeTimestamps() {
        int[][] intervals = {{-5, 0}, {5, 10}};
        assertTrue(solution.canAttendMeetings(intervals));
    }
}
