# Insert Interval

**LeetCode Link:** https://leetcode.com/problems/insert-interval/

## DESCRIPTION (inspired by Leetcode.com)
You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and end of the ith interval, sorted by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that:
1. No overlapping intervals exist in the result
2. The result is sorted
3. Intervals are merged when needed

## Example 1:
**Input:** intervals = [[1,2],[3,5],[6,9]], newInterval = [4,8]
**Output:** [[1,2],[3,9]]

## Example 2:
**Input:** intervals = [[1,5]], newInterval = [2,7]
**Output:** [[1,7]]

## Example 3:
**Input:** intervals = [[1,2],[3,5],[6,9]], newInterval = [10,12]
**Output:** [[1,2],[3,5],[6,9],[10,12]]

## Constraints:
- 0 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= starti <= endi <= 10^5
- newInterval.length == 2
- 0 <= start <= end <= 10^5

## Solution Explanation:
### Algorithm: Greedy Single Pass
Instead of sorting and using interval merging, we can insert the new interval by:
1. Adding all intervals that end before the new interval starts (no overlap)
2. Merging all overlapping intervals with the new interval
3. Adding all remaining intervals that start after the merged interval ends (no overlap)

### Example Walkthrough:
For intervals = [[1,2],[3,5],[6,9]], newInterval = [4,8]:

1. Add [1,2] (ends at 2, before newInterval starts at 4)
2. Merge overlapping intervals:
   - Check [3,5]: overlaps with [4,8] → merge to [3,8]
   - Check [6,9]: overlaps with [3,8] → merge to [3,9]
3. No more intervals to add
4. Result: [[1,2],[3,9]]

### Time and Space Complexity:

| Metric | Complexity |
|--------|-----------|
| Time   | O(n) single pass through intervals |
| Space  | O(1) excluding the output array |

### Edge Cases Handled:
- Empty intervals array → return single interval
- New interval before all → return with new interval first
- New interval after all → return with new interval last
- New interval overlaps multiple → merge all overlapping
- New interval completely contained → return original
- New interval completely contains all → return single merged interval
- Intervals touching boundaries (e.g., [1,5] and [5,7]) → merge as [1,7]
- Negative values → correctly handled in comparisons
