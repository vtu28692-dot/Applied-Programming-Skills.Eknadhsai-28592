/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    // Custom class to store node information with coordinates
    static class NodeInfo {
        TreeNode node;
        int row;
        int col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: col -> (row -> PriorityQueue of node values sorted in ascending order)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for BFS traversal storing node along with its coordinates
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo info = queue.poll();
            TreeNode node = info.node;
            int row = info.row;
            int col = info.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        
        // Traverse the outer TreeMap (sorted by col)
        for (TreeMap<Integer, PriorityQueue<Integer>> cols : map.values()) {
            List<Integer> list = new ArrayList<>();
            // Traverse the inner TreeMap (sorted by row)
            for (PriorityQueue<Integer> pq : cols.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            result.add(list);
        }

        return result;
    }
}