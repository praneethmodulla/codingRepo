/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode tempFast = head;
        ListNode tempSlow = head;
        while(tempFast != null && tempFast.next != null){
            tempFast = tempFast.next.next;
            tempSlow = tempSlow.next;
        }
        TreeNode root = new TreeNode(tempSlow.val);
        ListNode temp = head;
        while(temp.next != tempSlow){
            temp = temp.next;
        }
        temp.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(tempSlow.next);
        return root;
    }
}