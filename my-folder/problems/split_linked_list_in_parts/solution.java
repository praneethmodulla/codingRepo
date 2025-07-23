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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp =temp.next;
        }
        if(k >= len){
            temp = head;
            int i = 0;
            while(temp != null && i < k){
                res[i] = new ListNode(temp.val);
                temp = temp.next;
                i++;
            }
            return res;
        }
        int rem = len % k;
        int partLength = len / k;
        int i = 0;
        temp = head;
        while(i < k){
            int cnt = partLength;
            if(rem > 0){
                cnt += 1;
                rem--;
            }
            ListNode node = new ListNode(temp.val);
            ListNode headNode = node;
            int j = 1;
            while(j < cnt && temp != null){
                temp = temp.next;
                ListNode newNode = new ListNode(temp.val);
                node.next = newNode;
                node = newNode;
                j++;
            }
            temp = temp.next;
            res[i] = headNode;
            i++;
        }
        return res;
    }
}