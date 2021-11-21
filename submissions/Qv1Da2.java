/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    // DFS: 先dfs遍历成list，再逐个修改指针
    private List<Node> list;
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        list = new ArrayList();
        dfs(head);
        return buildList(list);
    }

    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        list.add(head);
        dfs(head.child);
        dfs(head.next);
    }

    private Node buildList(List<Node> list) {
        Node head = list.get(0);
        Node pre = head;
        for (int i = 1; i < list.size(); i++) {
            Node cur = list.get(i);
            pre.next = cur;
            pre.child = null;
            cur.prev = pre;
            pre = cur;
        }
        return head;
    }
}