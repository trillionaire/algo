/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node root = null;
        Node node = head;
        Map<Node, Node> map = new HashMap();
        // 1st path: build node
        while (node != null) {
            Node copy = new Node(node.val);
            map.put(node, copy);
            if (root == null) {
                root = copy;
            }
            node = node.next;
        }
        // 2nd path: build node's next & random
        node = head;
        while (node != null) {
            Node copy = map.get(node);
            copy.next = map.get(node.next);
            copy.random = map.get(node.random);
            node = node.next;
        }
        return root;
    }
}