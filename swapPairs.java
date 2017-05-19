/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Base case
        if (head == null) return null;
        if (head.next == null) return head;
        
        // Construct necessary ListNodes.
        ListNode result = new ListNode(0);
        ListNode slow = head, fast = head.next;
        result.next = fast;
        
        // Recursively swap pairs.
        ListNode temp = fast.next;
        fast.next = new ListNode(slow.val);
        fast.next.next = swapPairs(temp);
        return result.next;
    }
}