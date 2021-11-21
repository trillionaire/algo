/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        return path;
    }

    void dfs(TreeNode root, List<Integer> path) {
        if (root == null) return;
        dfs(root.left, path);
        path.add(root.val);
        dfs(root.right, path);
    }
}