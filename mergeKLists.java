/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode result = new ListNode(0);
        // Construct a min-heap data structure
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) return -1;
                else if (l1.val > l2.val) return 1;
                else return 0;
            }
        });
        ListNode temp = result;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) queue.add(temp.next);
        }
        return result.next;
    }
}