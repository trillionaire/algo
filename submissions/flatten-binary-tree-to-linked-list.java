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
  public void flatten(TreeNode root) {
    if (root == null) return;
    LinkedList<TreeNode> list = new LinkedList<>();
    dfs(root, list);
    TreeNode pre = list.removeFirst();
    pre.left = null;
    TreeNode cur;
    while (list.size() > 0) {
      cur = list.removeFirst();
      cur.left = null;
      pre.right = cur;
      pre = pre.right;
    }
  }

  private void dfs(TreeNode root, List<TreeNode> result) {
    if (root == null) {
      return;
    }
    result.add(root);
    if (root.left != null) {
      dfs(root.left, result);
    }
    if (root.right != null) {
      dfs(root.right, result);
    }
  }
}