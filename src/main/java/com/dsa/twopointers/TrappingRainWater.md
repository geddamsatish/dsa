# Trapping Rain Water

**LeetCode Link:** https://leetcode.com/problems/trapping-rain-water/

## DESCRIPTION (inspired by Leetcode.com)

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

## Example 1:

**Input:**
```
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

**Output:**
```
6
```

**Explanation:** The elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are trapped.

## Example 2:

**Input:**
```
height = [4,2,0,3,2,5]
```

**Output:**
```
9
```

## Constraints:

- `n == height.length`
- `1 <= n <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

## Follow Up:

Can you solve it in one pass using only O(1) extra space?

## Solution Explanation:

### Algorithm: Two-Pointer Approach

The key insight is that the amount of water trapped at any position depends on the minimum of the maximum heights on both its left and right sides.

**Algorithm Steps:**

1. **Initialize two pointers:**
   - `left = 0` (left boundary pointer)
   - `right = n - 1` (right boundary pointer)
   - `leftMax = 0` (maximum height seen from left)
   - `rightMax = 0` (maximum height seen from right)
   - `result = 0` (total water trapped)

2. **Move pointers towards each other:**
   - If `height[left] < height[right]`:
     - If `height[left] >= leftMax`: update `leftMax`
     - Else: add `leftMax - height[left]` to result (water trapped at this position)
     - Move `left` pointer right
   - Else:
     - If `height[right] >= rightMax`: update `rightMax`
     - Else: add `rightMax - height[right]` to result
     - Move `right` pointer left

3. **Continue until left and right pointers meet**

**Why This Works:**

- At each step, we process the side with smaller height
- We know water can only be trapped up to the height of the opposite wall (which we've already processed)
- For the smaller side, the water level is determined by the minimum of leftMax and rightMax
- We only need one pass and constant space

### Example Walkthrough (Example 1):

```
height = [0,1,0,2,1,0,1,3,2,1,2,1]
indices:  0 1 2 3 4 5 6 7 8 9 10 11

Initial: left=0, right=11, leftMax=0, rightMax=0, result=0

Step 1 (left=0, right=11): height[0]=0 < height[11]=1
  0 >= leftMax(0), update leftMax=0
  left++

Step 2 (left=1, right=11): height[1]=1 < height[11]=1
  1 >= leftMax(0), update leftMax=1
  left++

Step 3 (left=2, right=11): height[2]=0 < height[11]=1
  0 < leftMax(1), add 1-0=1, result=1
  left++

Step 4 (left=3, right=11): height[3]=2 > height[11]=1
  1 < rightMax(0), update rightMax=1
  right--

Step 5 (left=3, right=10): height[3]=2 < height[10]=2
  2 >= leftMax(1), update leftMax=2
  left++

... (continue process)

Final: result=6
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass through the array |
| **Space Complexity** | O(1) - only a few pointers, no extra data structures |

### Edge Cases Handled:

- Single element → 0 water trapped
- Two elements → 0 water trapped
- Ascending order → 0 water trapped (no valleys)
- Descending order → 0 water trapped
- Uniform height → 0 water trapped
- Valley pattern (e.g., [3,0,2]) → correctly calculates trapped water
- Multiple valleys → handles all water pockets
- Asymmetric walls → calculates based on minimum boundary
- Large height differences → correctly computes water level

### Why Two-Pointer vs Other Approaches:

- **Two-Pointer (O(1) space):** Optimal solution, most efficient
- **Dynamic Programming (O(n) space):** Pre-compute max heights, simpler to understand but uses extra space
- **Stack (O(n) space):** Uses decreasing stack approach, alternative solution

The two-pointer approach achieves the best space complexity while maintaining linear time complexity.
