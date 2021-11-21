/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set1 = new HashSet();
        ListNode node = headA;
        while (node != null) {
            set1.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set1.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}