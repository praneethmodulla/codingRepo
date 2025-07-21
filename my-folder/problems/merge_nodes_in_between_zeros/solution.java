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
    public ListNode mergeNodes(ListNode head) {
        ListNode result = null;
        ListNode temp = head;
        ListNode prev = null;
        int sum = 0;
        while(temp != null){
            if(temp.val == 0){
                if(prev != null){
                    prev.next = new ListNode(sum);
                    sum = 0;
                    prev = prev.next;
                } else {
                    if(sum > 0){
                        result = new ListNode(sum);
                        sum = 0;
                        prev = result;
                    }
                }
            } else {
                sum += temp.val;
            }
            temp = temp.next;
        }
        return result;
    }
}