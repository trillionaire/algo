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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t1 == t2;
        }
        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean isSameTree(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return (isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right));
    }
}