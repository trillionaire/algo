/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    0,1,0
    1,1
    (3-1)/2, (3)/2

    0,1,1,0
    1,2
    (4-1)/2,(4)/2
    */
    public boolean isPalindrome(ListNode head) {
        ListNode root = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        int[] chars = new int[len];
        head = root;
        int i = 0;
        while (head != null) {
            chars[i++] = head.val;
            head = head.next;
        }
        int l = (len - 1) / 2;
        int r = len / 2;
        while (l >= 0 && r < len) {
            if (chars[l--] != chars[r++]) {
                return false;
            }
        }
        return true;
    }
}