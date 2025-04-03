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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode curr = head;
        int len = 0;
        while(temp != null){
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
            len++;
        }
        int[] res = new int[len];
        res[len - 1] = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(prev.val);
        prev = prev.next;
        for(int i = len - 2; i >= 0; i--){
            if(prev!=null && (!st.isEmpty()) && prev.val < st.peek()){
                res[i] = st.peek();
            } 
            while(!st.isEmpty() && st.peek() <= prev.val){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = 0;
            } else {
                res[i] = st.peek();
            }
            st.push(prev.val);
            prev = prev.next;
        }
        return res;
    }
}