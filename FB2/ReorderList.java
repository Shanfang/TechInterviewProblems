/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        int size = stack.size();
        while (stack.size() > (size + 1) / 2) {
            ListNode node = stack.pop();
            ListNode nextNode = cur.next;
            cur.next = node;
            node.next = nextNode;
            cur = nextNode;
        }
        cur.next = null;
    }
}
