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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int numRotations = k%len;
        if(numRotations == 0){
            return head;
        }
        ListNode prevNode = null;
        ListNode newHead = head;
        int i = 0;
        while(i < len - numRotations){
            prevNode = newHead;
            newHead = newHead.next;
            i++; 
        }
        prevNode.next = null;
        temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }
}