/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = new ListNode(0);
        ListNode result = cur;
        ListNode top = head;
        ListNode[] temp = new ListNode[k];
        // Base case
        for (int i = 0; i < k; i++) {
            if (head == null) return top;
            temp[i] = new ListNode(0);
            temp[i].val = head.val;
            head = head.next;
        }
        for (int i = k - 1; i >= 0; i--) {
            cur.next = temp[i];
            cur = cur.next;
        }
        cur.next = reverseKGroup(head, k);
        return result.next;
    }
}