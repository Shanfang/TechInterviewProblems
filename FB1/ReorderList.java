/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
         Stack<ListNode> stack = new Stack<>();
         ListNode cur = head;
         while (cur != null) {
             stack.push(cur);
             cur = cur.next;
         }

         int counts = stack.size();
         cur = head;
         while (stack.size() > (counts + 1) / 2) {
             ListNode top = stack.pop();
             ListNode temp = cur.next;
             cur.next = top;
             top.next = temp;
             cur = temp;
         }
         if (cur != null) {
             cur.next = null;
         }
     }
 }
