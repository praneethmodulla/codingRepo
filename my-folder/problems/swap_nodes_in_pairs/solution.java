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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        return recurse(head);
    }

    public ListNode recurse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode temp = curr.next;
        curr.next = prev;
        prev.next = recurse(temp);
        return curr;
    }
}