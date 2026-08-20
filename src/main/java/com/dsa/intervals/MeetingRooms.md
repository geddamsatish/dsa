# Meeting Rooms

**LeetCode Link:** https://leetcode.com/problems/meeting-rooms/

## DESCRIPTION (inspired by Leetcode.com)
Given an array of meeting intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

## Example 1:
**Input:** intervals = [[0,30],[5,10],[15,20]]
**Output:** false

## Example 2:
**Input:** intervals = [[7,10],[2,4]]
**Output:** true

## Constraints:
- 0 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= starti < endi <= 10^6

## Solution Explanation:
### Algorithm: Sort and Check Adjacent Intervals
The key insight is that if we sort the intervals by start time, any overlap will occur between consecutive intervals. We can then iterate through the sorted intervals and check if the end time of the current meeting is greater than the start time of the next meeting.

### Example Walkthrough:
For intervals = [[0,30],[5,10],[15,20]]:

1. Sort by start time: [[0,30],[5,10],[15,20]]
2. Check consecutive pairs:
   - Compare [0,30] and [5,10]: 30 > 5, so there's an overlap → return false

For intervals = [[7,10],[2,4]]:

1. Sort by start time: [[2,4],[7,10]]
2. Check consecutive pairs:
   - Compare [2,4] and [7,10]: 4 ≤ 7, no overlap → continue
3. All intervals checked without overlap → return true

### Time and Space Complexity:

| Metric | Complexity |
|--------|-----------|
| Time   | O(n log n) for sorting, where n = number of intervals |
| Space  | O(1) if sorting in-place, O(n) for sorting algorithm overhead |

### Edge Cases Handled:
- Empty intervals array → return true
- Single meeting → return true
- Meetings that exactly touch at boundaries (e.g., [1,2] and [2,3]) → return true (no conflict)
- Nested meetings → return false
- Identical meeting times → return false
- Reverse order intervals → correctly handles after sorting
