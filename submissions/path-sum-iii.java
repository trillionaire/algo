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
    // DFS: 自顶向下，可不包含root
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 选root
        int rootVal = dfs(root, sum);
        // 不选root
        int leftVal = pathSum(root.left, sum);
        int rightVal = pathSum(root.right, sum);
        return rootVal + leftVal + rightVal;
    }

    // DFS：自顶向下，包含root
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        // 非叶子节点
        int rootVal = (sum == 0) ? 1 : 0;
        int leftVal = dfs(root.left, sum);
        int rightVal = dfs(root.right, sum);
        return rootVal + leftVal + rightVal;
    }
}