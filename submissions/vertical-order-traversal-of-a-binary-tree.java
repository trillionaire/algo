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
    private PriorityQueue<int[]> pq;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] -  o2[1];
                }
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });
        dfs(root, 0, 0);
        return getResult(pq);
    }

    private List<List<Integer>> getResult(PriorityQueue<int[]> pq) {
        List<List<Integer>> result = new ArrayList();
        int[] pre = pq.poll();
        List<Integer> list = new ArrayList();
        list.add(pre[2]);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //System.out.println(cur[0] + " , " + cur[1] + " , " + cur[2]);
            if (cur[1] != pre[1]) {
                result.add(new ArrayList(list));
                list = new ArrayList();
                list.add(cur[2]);
            } else {
                list.add(cur[2]);
            }
            pre = cur;
        }
        if (!list.isEmpty()) {
            result.add(list);
        }
        return result;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        pq.add(new int[] {x, y, root.val});
        dfs(root.left, x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }
}