/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

 public class Solution {
     public void connect(TreeLinkNode root) {
         if (root == null) {
             return;
         }

         Queue<TreeLinkNode> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()) {
             int size = queue.size();
             while (size > 0) {
                 TreeLinkNode node = queue.poll();
                 size--;
                 if (size > 0) {
                     node.next = queue.peek();
                 } else {
                     node.next = null;
                 }
                 if (node.left != null) {
                     queue.offer(node.left);
                 }
                 if (node.right != null) {
                     queue.offer(node.right);
                 }
             }
         }

     }
 }
