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
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode tail = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop().val + stack2.pop().val;
            ListNode node = new ListNode((sum + carry) % 10);
            node.next = tail;
            tail = node;
            carry = (sum + carry) / 10;
        }
        while (!stack1.isEmpty()) {
            int sum = carry + stack1.pop().val;
            ListNode node = new ListNode(sum % 10);
            node.next = tail;
            tail = node;
            carry = sum / 10;
        }
        while (!stack2.isEmpty()) {
            int sum = carry + stack2.pop().val;
            ListNode node = new ListNode(sum % 10);
            node.next = tail;
            tail = node;
            carry = sum / 10;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = tail;
            tail = node;
        }
        return tail;
    }
}
