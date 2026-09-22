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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case 1: both subtrees are null
        if (t1 == null && t2 == null) {
            return true;
        }
        
        // Base case 2: one subtree is null while the other isn't, or values differ
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        // Compare outer children (left of t1 with right of t2) 
        // and inner children (right of t1 with left of t2)
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}