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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null && len < k){
            len++;
            temp = temp.next;
        }
        if(len < k){
            return head;
        }

        ListNode prev = null;
        temp = head;
        ListNode curr = head.next;
        while(len > 0){
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
            len--;
        }
        temp = prev;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = reverseKGroup(curr, k);
        return prev;
    }
}