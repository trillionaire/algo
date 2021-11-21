/*
536. 从字符串生成二叉树
你需要从一个包括括号和整数的字符串构建一棵二叉树。

输入的字符串代表一棵二叉树。它包括整数和随后的 0 ，1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。

若存在左子结点，则从左子结点开始构建。

 

示例：

输入："4(2(3)(1))(6(5))"
输出：返回代表下列二叉树的根节点:

       4
     /   \
    2     6
   / \   / 
  3   1 5   

*/
    // DFS
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int left  = s.indexOf("(");
        if (left == -1) {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            return node;
        }

        TreeNode node = new TreeNode(Integer.valueOf(s.substring(0, left)));
        int right = left;
        int lcount = 0;
        int rcount = 0;
        while (right < s.length()) {
            if (s.charAt(right) == '(') {
                lcount++;
            } else if (s.charAt(right) == ')') {
                rcount++;
                if (lcount == rcount) {
                    break;
                }
            }
            right++;
        }
        node.left = str2tree(s.substring(left + 1, right));
        if (right < s.length() - 1) {
            node.right = str2tree(s.substring(right + 2, s.length() - 1));
        }
        return node;
    }