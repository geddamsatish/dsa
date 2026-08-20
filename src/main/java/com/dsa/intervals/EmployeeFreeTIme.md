# Employee Free Time

**LeetCode Link:** https://leetcode.com/problems/employee-free-time/

## DESCRIPTION (inspired by Leetcode.com)
Write a function to find the common free time for all employees from a schedule. Each employee's schedule is represented by a list of non-overlapping intervals sorted by start times. The function should return a list of finite, non-zero length intervals where all employees are free, also sorted in order.

## Example 1:
**Input:** schedule = [[[2,4],[7,10]],[[1,5]],[[6,9]]]
**Output:** [[5,6]]
**Explanation:** The three employees collectively have only one common free time interval, which is from 5 to 6.

## Example 2:
**Input:** schedule = [[[1,3],[5,6],[8,10]],[[2,4]],[[2,5],[9,12]]]
**Output:** [[6,8]]
**Explanation:** There is one common free time interval from 6 to 8 where all three employees are free.

## Constraints:
- 1 <= schedule.length <= 50
- 0 <= schedule[i].length <= 50
- 0 <= start < end <= 10^8
- For each employee, their intervals are non-overlapping and sorted

## Solution Explanation:
### Algorithm: Flatten, Merge, and Find Gaps
The key insight is to:
1. Flatten all intervals from all employees into one list
2. Merge overlapping intervals to get the total busy time
3. Find gaps between merged intervals - those are the free times

### Why this approach works:
- When we merge all busy intervals, we get a complete picture of when someone is busy
- The gaps between merged intervals are times when EVERYONE is free
- No employee is busy during these gap periods

### Example Walkthrough:
For schedule = [[[2,4],[7,10]],[[1,5]],[[6,9]]]:

1. Flatten all intervals: [2,4], [7,10], [1,5], [6,9]
2. Sort by start: [1,5], [2,4], [6,9], [7,10]
3. Merge overlapping: [1,5], [6,10]
   - [1,5] and [2,4] overlap → merged to [1,5]
   - [6,9] and [7,10] overlap → merged to [6,10]
4. Find gaps between merged intervals: 5 to 6
5. Result: [[5,6]] ✓

### Time and Space Complexity:

| Metric | Complexity |
|--------|-----------|
| Time   | O(n*m log(n*m)) where n = employees, m = intervals per employee |
| Space  | O(n*m) for flattened intervals |

### Edge Cases Handled:
- No free time (all time is busy) → return empty
- Single employee → return gaps in their schedule
- Multiple gaps in free time → return all gaps sorted
- Touching intervals (e.g., [1,2] and [2,3]) → merge into [1,3]
- Nested intervals → absorbed by larger interval
- Single-point intervals → handled correctly
- Negative time values → supported
- Large time ranges → handled efficiently
