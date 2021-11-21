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
    public int[] findMode(TreeNode root) {
        if (root == null) { return new int[0];}
        Map<Integer, Integer> map = new HashMap();
        dfs(root, map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        List<Integer> res = new ArrayList();
        int max = list.get(0).getValue();
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i).getValue()) {
                res.add(list.get(i).getKey());
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        dfs(node.left, map);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        dfs(node.right, map);        
    }
}