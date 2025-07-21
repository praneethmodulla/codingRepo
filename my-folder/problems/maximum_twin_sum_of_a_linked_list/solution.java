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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = temp;
        while(temp != null){
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr; 
        }
        int maxSum = Integer.MIN_VALUE;
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p2 != null && p1 != null){
            maxSum = Math.max(p1.val + p2.val, maxSum);
            p1 = p1.next;
            p2 = p2.next;
        }
        return maxSum;
    }
}