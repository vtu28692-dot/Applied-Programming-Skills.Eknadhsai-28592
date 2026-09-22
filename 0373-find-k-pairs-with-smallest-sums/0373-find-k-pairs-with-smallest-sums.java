import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }

        // Min-heap storing integer arrays of format: [indexInNums1, indexInNums2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // Initialize heap with first element of nums2 paired with up to k elements from nums1
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // Pop the smallest pair and offer the next candidate pair from nums2
        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[0];
            int j = curr[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // If there's a next element in nums2 for the current nums1[i], add it to heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}