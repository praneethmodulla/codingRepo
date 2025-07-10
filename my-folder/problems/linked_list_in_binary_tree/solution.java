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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return false;
        }
        return check(head, root);
    }

    public boolean check(ListNode head, TreeNode root){
        if(root == null){
            return false;
        }
        if(recurse(root, head)){
            return true;
        }
        return check(head, root.left) || check(head, root.right);
    }

    public boolean recurse(TreeNode node, ListNode head){
        if(head == null){
            return true;
        }
        if(node == null){
            return false;
        }
        if(node.val != head.val){
            return false;
        }
        return recurse(node.left, head.next) || recurse(node.right, head.next); 
    }
}