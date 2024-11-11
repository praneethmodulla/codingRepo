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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode resultHead = null;
        ListNode prevNode = null;
        ListNode temp = head;
        boolean firstNode = true;
        while(temp != null && temp.next != null){
            if(temp.val != temp.next.val){
                ListNode node = new ListNode(temp.val);
                if(firstNode){
                    resultHead = node;
                    prevNode = resultHead;
                    firstNode = false;
                } else {
                    prevNode.next = node;
                    prevNode = prevNode.next;
                }
                temp = temp.next; 
            } else if(temp.val == temp.next.val){
                ListNode dupNode = temp;
                while(temp!= null && temp.val == dupNode.val){
                    temp = temp.next;
                }
            }
        }
        if(temp != null && temp.next == null){
            if(firstNode){
                return temp;
            } else {
                prevNode.next = new ListNode(temp.val);
            }
        }
        return resultHead;
    }
}