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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenNodeHead = evenNode;
        ListNode prev = null;
        int i = 1;
        while(oddNode != null && evenNode != null){
            if(i%2 == 1){
                oddNode.next = evenNode.next;
                prev = oddNode;
                oddNode = evenNode.next;
            } else {
                evenNode.next = oddNode.next;
                evenNode = oddNode.next;
            }
            i++;
        } 
        if(evenNode == null){
            oddNode.next = evenNodeHead;
        }
        if(oddNode == null){
            prev.next = evenNodeHead;
        }
        return head;
    }
}