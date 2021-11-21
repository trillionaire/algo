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
    // DFS：二叉树。 先dfs建立parent图。再从target出发dfs找答案，分三条路left/right/parent，通过prev和next不同保障不走回头路。
    private List<Integer> result;
    private Map<Integer, TreeNode> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result = new ArrayList<>();
        graph = new HashMap();
        dfsBuildGraph(root);
        dfsGetResult(target, null, k);
        return result;
    }

    // 从target出发dfs找答案，分三条路left/right/parent，通过prev和next不同保障不走回头路
    private void dfsGetResult(TreeNode cur, TreeNode prev, int k) {
        if (k == 0) {
            result.add(cur.val);
            return;
        }
        // cur -> left
        if (cur.left != null && cur.left != prev) {
            dfsGetResult(cur.left, cur, k - 1);
        }
        // cur -> right
        if (cur.right != null && cur.right != prev) {
            dfsGetResult(cur.right, cur, k - 1);            
        }
        // cur -> parent
        TreeNode parent = graph.get(cur.val);
        if (parent != null && parent != prev) {
            dfsGetResult(parent, cur, k - 1);
        }
    }
    // dfs建立parent图
    private void dfsBuildGraph(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {            
            graph.put(root.left.val, root);
            dfsBuildGraph(root.left);
        }
        if (root.right != null) {
            graph.put(root.right.val, root);
            dfsBuildGraph(root.right);
        }
    }

}