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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp != null){
            while(!stack.isEmpty() && stack.peek().val < temp.val){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek().val >= temp.val){
                stack.push(temp);
            }
            temp = temp.next;
        }
        ListNode prevNode = stack.pop();
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = prevNode;
            prevNode = node;
        }
        return prevNode;
    }
}