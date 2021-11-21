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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        List<TreeNode> path = new ArrayList();
        TreeNode res = null;
        dfs(root, path, p);
        int i = 0;
        for (; i < path.size(); i++) {
            //System.out.println(path.get(i).val);
            if (p == path.get(i)) {
                break;
            }
        }
        if (i < path.size() - 1) {
            return path.get(i + 1);
        }
        return res;
    }

    private void dfs(TreeNode node, List<TreeNode> path, TreeNode p) {
        if (node == null) {
            return;
        }
        dfs(node.left, path, p);
        path.add(node);
        dfs(node.right, path, p);
    }
}