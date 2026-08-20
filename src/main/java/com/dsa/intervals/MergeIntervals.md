# Merge Intervals

**LeetCode Link:** https://leetcode.com/problems/merge-intervals/

## DESCRIPTION (inspired by Leetcode.com)
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Two intervals are considered overlapping if they share any point in common.

## Example 1:
**Input:** intervals = [[1,3],[2,6],[8,10],[15,18]]
**Output:** [[1,6],[8,10],[15,18]]
**Explanation:** Merging [1,3] and [2,6] results in [1,6].

## Example 2:
**Input:** intervals = [[1,4],[4,5]]
**Output:** [[1,5]]
**Explanation:** [1,4] and [4,5] merge into [1,5] as they share endpoint 4.

## Constraints:
- 1 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= starti <= endi <= 10^4

## Solution Explanation:
### Algorithm: Sort and Merge
The greedy approach works because:
1. Sort intervals by start time
2. Iterate through sorted intervals and merge overlapping ones
3. For each interval, check if it overlaps with the last merged interval
4. If yes, extend the merged interval's end; if no, add current interval to result

### Why sort by start time?
When intervals are sorted by start time, we know:
- If current interval's start > last interval's end, no overlap possible
- All overlapping intervals with an interval will come after sorting

### Example Walkthrough:
For intervals = [[1,3],[2,6],[8,10],[15,18]]:

1. Sort by start: [[1,3],[2,6],[8,10],[15,18]] (already sorted)
2. Start with merged = [[1,3]]
3. Process [2,6]: 2 <= 3? YES → Overlap! Merge: [1, max(3,6)] = [1,6]
4. Process [8,10]: 8 > 6? NO overlap. Add [8,10]. merged = [[1,6],[8,10]]
5. Process [15,18]: 15 > 10? NO overlap. Add [15,18]. merged = [[1,6],[8,10],[15,18]]

Result: [[1,6],[8,10],[15,18]] ✓

### Time and Space Complexity:

| Metric | Complexity |
|--------|-----------|
| Time   | O(n log n) for sorting, where n = number of intervals |
| Space  | O(n) for the result array (excluding output) |

### Edge Cases Handled:
- Empty intervals array → return empty result
- Single interval → return as is
- All non-overlapping intervals → return all intervals
- All overlapping intervals → merge into one interval
- Intervals with same start time → merge by end time
- Intervals touching at endpoints → merge them
- Nested intervals → absorb smaller into larger
- Reverse order intervals → sorted by start time before processing
- Negative values → correctly handled in comparisons
