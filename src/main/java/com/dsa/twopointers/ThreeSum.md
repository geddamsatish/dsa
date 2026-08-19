# 3Sum

**LeetCode Link:** https://leetcode.com/problems/3sum/description/

## DESCRIPTION (inspired by Leetcode.com)

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

**Notice:** The solution set must not contain duplicate triplets.

## Example 1:

**Input:**
```
nums = [-1,0,1,2,-1,-4]
```

**Output:**
```
[[-1,-1,2],[-1,0,1]]
```

**Explanation:** 
- nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
- nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
- nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
- The distinct triplets are [-1,0,1] and [-1,-1,2].
- Notice that the order of the output and the order of the triplets does not matter.

## Example 2:

**Input:**
```
nums = [0,1,1]
```

**Output:**
```
[]
```

**Explanation:** The only possible triplet does not sum up to 0.

## Example 3:

**Input:**
```
nums = [0,0,0]
```

**Output:**
```
[[0,0,0]]
```

**Explanation:** The only possible triplet sums up to 0.

## Constraints:

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

## Solution Explanation:

### Algorithm: Sort + Two Pointers

The key insight is to reduce the 3Sum problem to multiple 2Sum problems using sorting and a two-pointer approach.

**Algorithm Steps:**

1. **Sort the array:**
   - Sort the input array in ascending order
   - Time: O(n log n), but enables efficient duplicate handling and two-pointer technique

2. **Fix one element and use two pointers:**
   - Iterate through the array with index `i` (0 to n-3)
   - For each `nums[i]`, find two numbers that sum to `-nums[i]` using two pointers
   - Use `left` pointer starting at `i+1` and `right` pointer starting at `n-1`

3. **Two-pointer logic:**
   - While `left < right`:
     - Calculate `sum = nums[i] + nums[left] + nums[right]`
     - If `sum == 0`, add the triplet to result and move both pointers
     - If `sum < 0`, move `left++` to increase the sum
     - If `sum > 0`, move `right--` to decrease the sum

4. **Handle duplicates:**
   - Skip duplicate values at each pointer position
   - For the anchor element: skip if `nums[i] == nums[i-1]`
   - For left pointer: skip if `nums[left] == nums[left+1]` after finding a triplet
   - For right pointer: skip if `nums[right] == nums[right-1]` after finding a triplet

5. **Return all unique triplets**

### Example Walkthrough (Example 1):

```
nums = [-1,0,1,2,-1,-4]
After sorting: [-4,-1,-1,0,1,2]

i=0 (anchor=-4): left=1, right=5
  sum = -4 + (-1) + 2 = -3 < 0, move left
  sum = -4 + 0 + 2 = -2 < 0, move left
  sum = -4 + 1 + 2 = -1 < 0, move left
  left >= right, stop

i=1 (anchor=-1): left=2, right=5
  sum = -1 + (-1) + 2 = 0, found! triplet [-1,-1,2]
  Move left and right, skip duplicates
  left=3, right=4
  sum = -1 + 0 + 1 = 0, found! triplet [-1,0,1]
  Move left and right
  left >= right, stop

i=2 (anchor=-1): Skip (duplicate of previous)

i=3 (anchor=0): left=4, right=5
  sum = 0 + 1 + 2 = 3 > 0, move right
  left >= right, stop

Result: [[-1,-1,2], [-1,0,1]]
```

### Why This Works:

**Sorting Benefits:**
- Enables two-pointer technique for finding pairs
- Makes duplicate handling straightforward
- Guarantees we don't miss any valid triplets

**Correctness:**
- By fixing one element and using two pointers on a sorted array, we systematically explore all possible combinations
- The two-pointer approach in a sorted array guarantees finding all pairs that sum to a target
- Duplicate handling ensures the result set contains only unique triplets

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n²) - O(n log n) for sorting + O(n²) for the nested loops (O(n) iterations × O(n) two-pointer search) |
| **Space Complexity** | O(1) or O(n) - Depending on sorting algorithm (in-place vs not). Not counting output array. |

### Edge Cases Handled:

- Array with minimum length (3 elements) → correctly finds or doesn't find triplet
- All zeros → correctly identifies [0,0,0] as a valid triplet
- All same non-zero elements → correctly returns empty result
- Array with positive numbers only → correctly returns empty result (no triplet sums to 0)
- Array with negative numbers only → correctly returns empty result
- Array with single valid triplet → correctly identified
- Array with multiple valid triplets → all found without duplicates
- Array with many duplicates → duplicates handled correctly
