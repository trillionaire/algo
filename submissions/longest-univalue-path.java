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
    // https://leetcode-cn.com/problems/longest-univalue-path/solution/guan-yu-di-gui-si-lu-de-chao-xiang-xi-ge-ren-jian-/
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestPath(root);
        return ans;
    }

    //递归函数功能：搜寻以node为起点的最长同值路径:要么是以node为起点的左子树，要么是以node为起点的右子树
    public int longestPath(TreeNode node) {
        if (node == null) return 0;
        int maxLorRres=0;
        int left = longestPath(node.left); //node左子树的最长同值路径
        int right = longestPath(node.right);//node右子树的最长同值路径
        //这种情况对于寻找最长同值路径长有帮助，对于搜索以root为路径起始点的最长路径没有帮助
        if (node.left != null && node.left.val == node.val&&node.right != null && node.right.val == node.val) {
            ans=Math.max(ans, left + right+2);
        }
        //从左右子树中选择最长的同值路径
        if(node.left!=null&&node.left.val == node.val){
            maxLorRres=left+1;
        }
        if(node.right!=null&&node.right.val==node.val){
            maxLorRres=Math.max(maxLorRres,right+1);
        }
        //从ans与maxLorRres中更新最大值
        ans=Math.max(ans,maxLorRres);
        return maxLorRres; //所以你能知道为什么返回这个值了吗？
    }
}