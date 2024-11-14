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
    ListNode linkedList;
    public Solution(ListNode head) {
        linkedList = head;
    }
    
    public int getRandom() {
        int len = 0;
        ListNode temp = linkedList;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int range = len;
        int rand = (int)(Math.random() * range) + 1;
        ListNode res = linkedList;
        int i = 1;
        while(i < rand){
            res = res.next;
            i++;
        }
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */