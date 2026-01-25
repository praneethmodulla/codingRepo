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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        ListNode curr = head;
        while(temp.next != null){
            int gcdVal = gcdCalc(temp.val, temp.next.val);
            ListNode newNode = new ListNode(gcdVal);
            newNode.next = temp.next;
            curr = temp.next;
            temp.next = newNode;
            temp = curr;
        }
        return head;
    }

    public int gcdCalc(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}