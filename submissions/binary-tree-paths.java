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
    private List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList();
        dfs(root, "");
        return ans;
    }
    
    private void dfs(TreeNode root, String path) {
        // 空节点
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        // 叶节点
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }
        //递归左右子节点： path是String,每次为新对象，所以不用回溯。
        sb.append("->");
        dfs(root.left, sb.toString());
        dfs(root.right, sb.toString());
    }
}