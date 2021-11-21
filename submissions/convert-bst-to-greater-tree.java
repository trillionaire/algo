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
    public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        Stack<Integer> stack = new Stack();
        dfs(root, stack);
        for (int i = stack.size() - 2 ; i >= 0; i--) {
            stack.set(i, stack.get(i) + stack.get(i + 1));
        }
        gtDfs(root, stack);
        return root;
    }

    private void dfs(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        dfs(root.left, stack);
        stack.push(root.val);
        dfs(root.right, stack);
    }
    private void gtDfs(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        gtDfs(root.right, stack);
        root.val = stack.pop();
        gtDfs(root.left, stack);
    }
}