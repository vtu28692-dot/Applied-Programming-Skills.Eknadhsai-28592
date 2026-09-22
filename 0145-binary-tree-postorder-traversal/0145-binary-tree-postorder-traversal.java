class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        dfs(node.left, result);  // Left
        dfs(node.right, result); // Right
        result.add(node.val);    // Root
    }
}