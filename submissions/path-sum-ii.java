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
    private List<List<Integer>> paths;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList();
        if (root == null) {
            return paths;
        }

        dfs(root, targetSum, new ArrayList());
        return paths;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                paths.add(new ArrayList(path));
                path.remove(path.size() - 1);
                return;
            }            
        }
        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        path.remove(path.size() - 1);
    }
}