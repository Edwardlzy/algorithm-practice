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
        ListNode result = new ListNode(0);
        int k = lists.length;
        int index = 0, next = Integer.MAX_VALUE;
        boolean finish = true;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                if (lists[i].val < next) {
                    next = lists[i].val;
                    index = i;
                    finish = false;
                }
            }
        }
        if (finish) return result.next;
        result.next = new ListNode(lists[index].val);
        result = result.next;
        lists[index] = lists[index].next;
        result.next = mergeKLists(lists);
        return result;
    }
}