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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        ListNode temp = head;
        ListNode prev = null;
        ListNode result = null;
        ListNode curr = head;
        while(temp != null){
            if(set.contains(temp.val)){
                if(prev != null){
                    prev.next = null;
                }
                temp = temp.next;
                curr = temp;
            } else {
                if(prev == null){
                    prev = temp;
                    result = temp;
                    temp = temp.next;
                } else {
                    prev.next = temp;
                    prev = temp;
                    temp = temp.next;
                }
            }
        }
        return result;
    }
}