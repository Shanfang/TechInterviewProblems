/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// divide and conquer
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

        return divideConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideConquer(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode first = divideConquer(lists, start, mid);
        ListNode second = divideConquer(lists, mid + 1, end);
        return mergeTwo(first, second);
    }

    private ListNode mergeTwo(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        ListNode dummy = new ListNode(-1);
        ListNode preHead = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                dummy.next = first;
                first = first.next;
            } else {
                dummy.next = second;
                second = second.next;
            }
            dummy = dummy.next;
        }

        dummy.next = first == null ? second : first;
        return preHead.next;
    }
}

 // priority queue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode preHead = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            dummy.next = cur;
            dummy = dummy.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return preHead.next;
    }
}
