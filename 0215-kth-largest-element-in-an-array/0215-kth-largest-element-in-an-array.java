import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            // Keep heap size at most k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}