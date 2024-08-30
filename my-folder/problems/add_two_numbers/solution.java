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
        int carryOver = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode l3 = null;
        ListNode prevNode = null;
        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carryOver;
            carryOver = 0;
            if(sum >= 10){
                carryOver = sum/10;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            if(l3 == null){
                l3 = node;
            } else {
                prevNode.next = node;
            }
            prevNode = node;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 == null && temp2 != null){
            int sum = temp2.val + carryOver;
            carryOver = 0;
            if(sum >= 10){
                carryOver = sum/10;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            if(l3 == null){
                l3 = node;
            } else {
                prevNode.next = node;
            }
            prevNode = node;
            temp2 = temp2.next;
        }
        while(temp2 == null && temp1 != null){
            int sum = temp1.val + carryOver;
            carryOver = 0;
            if(sum >= 10){
                carryOver = sum/10;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            if(l3 == null){
                l3 = node;
            } else {
                prevNode.next = node;
            }
            prevNode = node;
            temp1 = temp1.next;
        }
        if(carryOver != 0){
            ListNode node = new ListNode(carryOver);
            prevNode.next = node;
        }
        return l3;
    }
}