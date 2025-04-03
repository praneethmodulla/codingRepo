/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }
        Node temp = head;
        Node next = temp.next;
        if(next == temp){
            temp.next = node;
            node.next = temp;
            return head;
        }
        if(temp.val <= node.val && node.val <= next.val){
            node.next = next;
            temp.next = node;
            return head;
        }
        temp = next;
        next = temp.next;
        while(temp != head){
            if(node.val >= temp.val && node.val <= next.val){
                node.next = next;
                temp.next = node;
                return head;
            } else if(node.val >= temp.val && node.val >= next.val && next.val < temp.val){
                node.next = next;
                temp.next = node;
                return head;
            } else if(next.val < temp.val && node.val <= temp.val && node.val <= next.val){
                node.next = next;
                temp.next = node;
                return head;
            }
            temp = next;
            next = temp.next;
        }
        temp.next = node;
        node.next = next;
        return head;
    }
}