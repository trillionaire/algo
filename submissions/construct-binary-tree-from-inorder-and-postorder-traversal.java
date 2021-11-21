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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int clLen = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                clLen = i;
                break;
            }
        }
        int crLen = inorder.length - clLen - 1;
        int[] lInorder =  Arrays.copyOfRange(inorder, 0, clLen);
        int[] lPostorder =  Arrays.copyOfRange(postorder, 0, clLen);
        int[] rInorder = Arrays.copyOfRange(inorder, clLen + 1, inorder.length);
        int[] rPostorder =  Arrays.copyOfRange(postorder, clLen, inorder.length - 1);
        root.left = buildTree(lInorder, lPostorder);
        root.right = buildTree(rInorder, rPostorder);
        return root;
    }
}