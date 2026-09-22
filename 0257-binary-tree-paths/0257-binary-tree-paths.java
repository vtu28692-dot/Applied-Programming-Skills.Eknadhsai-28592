class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            backtrack(root, new StringBuilder(), paths);
        }
        return paths;
    }

    private void backtrack(TreeNode node, StringBuilder sb, List<String> paths) {
        if (node == null) return;

        int len = sb.length();
        sb.append(node.val);

        if (node.left == null && node.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            backtrack(node.left, sb, paths);
            backtrack(node.right, sb, paths);
        }

        // Reset StringBuilder to original length for backtracking
        sb.setLength(len);
    }
}