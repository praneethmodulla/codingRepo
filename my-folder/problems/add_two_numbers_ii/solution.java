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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseList(l1);
        ListNode head2 = reverseList(l2);
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode result = null;
        ListNode prev = null;
        int carryOver = 0;
        while(temp1 != null && temp2 != null){
            int val = temp1.val + temp2.val + carryOver;
            if(val >= 10){
                carryOver = 1;
                val = val%10;
            } else {
                carryOver = 0;
            }
            ListNode node = new ListNode(val);
            if(prev != null){
                prev.next = node;
            }
            if(prev == null){
                result = node;
            }
            prev = node;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null && temp2 == null){
            int val = temp1.val + carryOver;
            if(val >= 10){
                carryOver = 1;
                val = val%10;
            } else {
                carryOver = 0;
            }
            ListNode node = new ListNode(val);
            if(prev != null){
                prev.next = node;
            }
            prev = node;
            temp1 = temp1.next;
        }
        while(temp2 != null && temp1 == null){
            int val = temp2.val + carryOver;
            if(val >= 10){
                carryOver = 1;
                val = val%10;
            } else {
                carryOver = 0;
            }
            ListNode node = new ListNode(val);
            if(prev != null){
                prev.next = node;
            }
            prev = node;
            temp2 = temp2.next;
        }
        if(carryOver == 1){
            ListNode node = new ListNode(carryOver);
            if(prev != null){
                prev.next = node;
            }
            prev = node;
        }
        return reverseList(result);
    }

    public ListNode reverseList(ListNode head){
        ListNode temp = head;
        ListNode curr = temp;
        ListNode prev = null;
        while(temp != null){
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        return prev;
    }
}