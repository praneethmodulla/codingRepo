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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tempFast = head;
        ListNode tempSlow = head;
        ListNode prev = null;
        while(tempFast != null && tempFast.next != null){
            tempFast = tempFast.next.next;
            prev = tempSlow;
            tempSlow = tempSlow.next;
        }
        if(prev == null){
            return prev;
        }
        prev.next = tempSlow.next;
        return head;
    }
}