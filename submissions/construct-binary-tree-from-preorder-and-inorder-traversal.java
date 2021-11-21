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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int rVal = preorder[0];
        TreeNode root = new TreeNode(preorder[0]);
        int lLen = 0;
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == rVal) {
                lLen = i;
                break;
            }
        }
        int[] lPreOrder = new int[lLen];
        int[] lInOrder = new int[lLen];
        int[] rPreOrder = new int[len - lLen - 1];
        int[] rInOrder = new int[len - lLen - 1];

        // build left right tree
        BuildLeftTree(preorder, lLen, lPreOrder, rPreOrder);
        buildRightTree(inorder, lLen, lInOrder, rInOrder);
        TreeNode left = buildTree(lPreOrder, lInOrder);
        TreeNode right = buildTree(rPreOrder, rInOrder);
        root.left = left;
        root.right = right;
        return root;
    }

    private void buildRightTree(int[] inorder, int lLen, int[] lInOrder, int[] rInOrder) {
        for (int i = 0; i < inorder.length; i++) {
            if (i < lLen) {
                lInOrder[i] = inorder[i];
            } else if (i > lLen) {
                rInOrder[i - lLen - 1] = inorder[i];
            }
        }
    }

    private void BuildLeftTree(int[] preorder, int lLen, int[] lPreOrder, int[] rPreOrder) {
        for (int i = 1; i < preorder.length; i++) {
            if (i <= lLen) {
                lPreOrder[i - 1] = preorder[i];
            } else {
                rPreOrder[i - lLen - 1] = preorder[i];
            }
        }
    }

}