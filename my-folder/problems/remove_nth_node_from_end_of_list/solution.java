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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        if(head.next == null && n == 1){
            return null;
        }
        ListNode tempAhead = head;
        ListNode temp = head;
        ListNode prev = null;
        int cnt = 0;
        while(cnt < n){
            tempAhead = tempAhead.next;
            cnt++;
        }

        while(tempAhead != null){
            tempAhead = tempAhead.next;
            prev = temp;
            temp = temp.next;
        }
        if(prev == null){
            head = temp.next;
            return head;
        }
        prev.next = temp.next;

        return head;
    }
}