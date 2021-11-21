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
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        //if (l.left == null && r.right == null) return ((l.val == r.val) &&());
        //if (l.left == null || r.right == null) return false;
        return ((l.val == r.val) && check(l.left, r.right) && check(l.right, r.left));
    }
}