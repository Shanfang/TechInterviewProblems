/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 // no extra space required
 public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode temp = cur.next;
            cur.next = newNode;
            newNode.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur != null) {
            RandomListNode temp = cur.next.next;
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = temp;
        }

        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode dupCur = dummy;
        while (cur != null) {
            RandomListNode temp = cur.next.next;
            dupCur.next = cur.next;
            dupCur = cur.next;
            cur.next = temp;
            cur = temp;
        }
        return dummy.next;
    }
}
 // O(N) space complexity
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            // hashmap permits null key and null value, so even cur.random == null,
            // we can use the get() method, and get null value, which coincides with the random pointer of the copied node
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
