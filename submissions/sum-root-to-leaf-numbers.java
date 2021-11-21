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
    private int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        int cur = val * 10 + Integer.valueOf(root.val);
        if (root.left == null && root.right == null) {
            ans += cur;
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}