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
    // 非自顶而下
    // https://leetcode-cn.com/problems/paths-with-sum-lcci/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-w3hu/
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int leftVal = pathSum(root.left, sum);
        int rightVal = pathSum(root.right, sum);
        int rootVal = dfs(root, sum);
        return leftVal + rightVal + rootVal;
    }
    // path begin with root
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left, sum - root.val);
        int rightVal = dfs(root.right, sum - root.val);
        int rootVal = (sum == root.val) ? 1 : 0;
        return leftVal + rightVal + rootVal;
    }
}