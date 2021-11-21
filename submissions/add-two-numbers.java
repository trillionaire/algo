/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        ListNode l = l1;
        ListNode r = l2;
        ListNode root = new ListNode(0);
        ListNode cur = root;


        while (l != null || r != null) {
            int val = 0;
            if (l != null) { val += l.val; l = l.next;}
            if (r != null) { val += r.val; r = r.next;}
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        cur = root;
        while (cur.next != null) {
            if (cur.val >= 10) {
                cur.val -= 10;
                cur.next.val += 1;
            }
            cur = cur.next;
        }
        if (cur.val >= 10) {
            cur.val -= 10;
            cur.next = new ListNode(1);
        }
        return root.next;
    }
}