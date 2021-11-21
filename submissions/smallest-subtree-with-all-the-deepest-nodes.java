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
    private class Helper {
        TreeNode node;
        int depth;
        Helper(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
        public TreeNode getNode() {
            return node;
        }
        public int getDepth() {
            return depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode res = root;
        return dfs(root).node;
    }

    Helper dfs(TreeNode node) {
        if (node == null) { return new Helper(null, 0); }
        Helper left = dfs(node.left);
        Helper right = dfs(node.right);
        if (left.getDepth() > right.getDepth()) {
            return new Helper(left.getNode(), left.getDepth() + 1);
        }
        if (left.getDepth() < right.getDepth()) {
            return new Helper(right.getNode(), right.getDepth() + 1);
        }
        return new Helper(node, left.getDepth() + 1);
    }
}