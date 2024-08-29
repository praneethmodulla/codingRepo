/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tempFast = head;
        ListNode tempSlow = head;

        while(tempFast != null && tempFast.next != null){
            tempFast = tempFast.next.next;
            tempSlow = tempSlow.next;
            if(tempFast == tempSlow){
                tempFast = head;
                break;
            }
        }

        if(tempFast == null || tempFast.next == null){
            return null;
        }
        while(tempFast != tempSlow){
            tempFast = tempFast.next;
            tempSlow = tempSlow.next;
        }
        return tempFast;
    }
}