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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode prevNode = null;
        int num = 1;
        while(temp != null && num < left){
            prevNode = temp;
            temp = temp.next;
            num++;
        }
        ListNode prev = null;
        ListNode curr = temp;
        while(num <= right){
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
            num++;
        }

        if(prevNode != null){
            prevNode.next.next = temp;
            prevNode.next = prev;
            return head;
        }
        head.next = temp;
        return prev;
    }
}