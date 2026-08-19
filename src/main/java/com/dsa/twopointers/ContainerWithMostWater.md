# Container With Most Water

**LeetCode Link:** https://leetcode.com/problems/container-with-most-water/description/

## DESCRIPTION (inspired by Leetcode.com)

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the ith line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

**Notice:** You may not slant the container.

## Example 1:

**Input:**
```
height = [1,8,6,2,5,4,8,3,7]
```

**Output:**
```
49
```

**Explanation:** The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

## Example 2:

**Input:**
```
height = [1,1]
```

**Output:**
```
1
```

## Constraints:

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

## Solution Explanation:

### Algorithm: Two-Pointer Approach

The key insight is to use two pointers starting from both ends of the array and move them towards each other based on which side has the smaller height.

**Algorithm Steps:**

1. **Initialize two pointers:**
   - `left` pointer starts at index 0
   - `right` pointer starts at index n-1

2. **Traverse and calculate area:**
   - While `left < right`:
     - Calculate the area formed by the two lines at `left` and `right`
     - Area = `min(height[left], height[right]) * (right - left)`
     - Track the maximum area found
     - Move the pointer pointing to the shorter line inward (to potentially find a taller line)
       - If `height[left] < height[right]`, move `left++`
       - Else, move `right--`

3. **Return the maximum area** found

**Why This Works:**

The width decreases with each move, so we need the height to increase to get a larger area. By moving the pointer at the shorter line inward, we have a chance to find a taller line that might compensate for the loss in width. Moving the taller line inward would only decrease the area since:
- Width decreases
- Height is limited by the minimum (which is already the shorter line)
- So area can only stay same or decrease

**Proof:**
Let i and j be the indices of the optimal container where i < j. Without loss of generality, assume height[i] ≤ height[j].

Starting from left=0, right=n-1, if height[left] < height[right], we move left forward. We will eventually reach left=i. When left=i, if right > j, we will keep decrementing right until we reach j (because height[i] would be the minimum at each step). Once both pointers are at i and j, we find the maximum area.

### Example Walkthrough (Example 1):

```
height = [1,8,6,2,5,4,8,3,7]
indices =  0 1 2 3 4 5 6 7 8

Step 1: left=0 (h=1), right=8 (h=7), area = min(1,7)*8 = 8, move left
Step 2: left=1 (h=8), right=8 (h=7), area = min(8,7)*7 = 49, move right
Step 3: left=1 (h=8), right=7 (h=3), area = min(8,3)*6 = 18, move right
Step 4: left=1 (h=8), right=6 (h=8), area = min(8,8)*5 = 40, move right
Step 5: left=1 (h=8), right=5 (h=4), area = min(8,4)*4 = 16, move right
Step 6: left=1 (h=8), right=4 (h=5), area = min(8,5)*3 = 15, move right
Step 7: left=1 (h=8), right=3 (h=2), area = min(8,2)*2 = 4, move right
Step 8: left=1 (h=8), right=2 (h=6), area = min(8,6)*1 = 6, move right
Step 9: left >= right, stop

Maximum area = 49 ✓
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass through the array |
| **Space Complexity** | O(1) - only using two pointers |

### Edge Cases Handled:

- Array with all same heights → returns area based on distance
- Array with increasing heights → finds optimal pair
- Array with decreasing heights → finds optimal pair
- Very small containers → correctly identifies smallest valid area
