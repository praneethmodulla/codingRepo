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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode lessHead = null;
        boolean firstNode1 = true;
        ListNode greatHead = null;
        boolean firstNode2 = true;
        ListNode prevNode1 = null;
        ListNode prevNode2 = null;
        ListNode temp = head;
        while(temp != null){
            ListNode node = new ListNode(temp.val);
            if(temp.val < x){
                if(firstNode1){
                    lessHead = node;
                    prevNode1 = node;
                    firstNode1 = false;
                } else {
                    prevNode1.next = node;
                    prevNode1 = prevNode1.next;
                }
            } else {
                if(firstNode2){
                    firstNode2 = false;
                    greatHead = node;
                    prevNode2 = node;
                } else {
                    prevNode2.next = node;
                    prevNode2 = prevNode2.next;
                }
            }
            temp = temp.next;
        }
        if(prevNode1 != null){
            prevNode1.next = greatHead;
            return lessHead;
        }
        return greatHead;
    }
}