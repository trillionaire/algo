/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        ListNode r = head;
        // move right to gap
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        if (r == null) {
            return head.next;
        }
        // move right to null
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        // remove l.next
        l.next = l.next.next;
        return head;
    }
}