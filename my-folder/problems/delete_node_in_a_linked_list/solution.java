/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode nextNode = node.next;
        while(nextNode.next != null){
            temp.val = nextNode.val;
            nextNode = nextNode.next;
            temp = temp.next;
        }
        if(nextNode.next == null){
            temp.val = nextNode.val;
            temp.next = null;
        }
        return;
    }
}