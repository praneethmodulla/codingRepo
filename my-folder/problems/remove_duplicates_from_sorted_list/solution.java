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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        } 
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode tempNext = head.next;
        while(tempNext != null){
            if(temp.val != tempNext.val){
                temp = temp.next;
            } else {
                temp.next = tempNext.next;
            }
            tempNext = tempNext.next;
        }
        return head;
    }
}