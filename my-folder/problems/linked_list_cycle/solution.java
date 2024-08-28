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
    public boolean hasCycle(ListNode head) {
        ListNode tempFast = head;
        ListNode tempSlow = head;

        while(tempFast != null && tempFast.next != null){
            tempSlow = tempSlow.next;
            tempFast = tempFast.next.next;
            if(tempSlow == tempFast){
                return true;
            }
        }

        return false;
    }
}