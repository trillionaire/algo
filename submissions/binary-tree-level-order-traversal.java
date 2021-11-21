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
    // BFS：
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return new ArrayList();
        }
        TreeNode iter = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(iter);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(curList);
            depth++;
        }
        return result;
    }
}