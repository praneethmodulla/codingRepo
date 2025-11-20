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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            if(temp != null){
                pq.add(temp);
            }
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while(!pq.isEmpty()){
            prev.next = pq.poll();
            prev = prev.next;
            if(prev.next != null){
                pq.add(prev.next);
            }
        }
        return result.next;
    }
}