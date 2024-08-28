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
    public ListNode middleNode(ListNode head) {
        ListNode tempSlow = head;
        ListNode tempFast = head;
        while(tempFast != null && tempFast.next != null){
            tempSlow = tempSlow.next;
            tempFast = tempFast.next.next;
        }
        return tempSlow;
    }
}