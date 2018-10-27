/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
