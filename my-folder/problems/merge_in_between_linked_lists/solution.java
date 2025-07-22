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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        int len = 1;
        while(temp != null && len < a){
            temp = temp.next;
            len++;
        }
        ListNode start = temp;
        ListNode ptr = temp.next;
        while(ptr != null && len < b){
            ptr = ptr.next;
            len++;
        }
        ListNode connect = ptr.next;
        start.next = list2;
        temp = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = connect;
        return list1;
    }
}