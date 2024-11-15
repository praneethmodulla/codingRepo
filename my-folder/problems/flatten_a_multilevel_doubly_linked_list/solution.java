/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node prevNode = null;
    public Node headNode = null;
    public Node flatten(Node head) {
        recurse(head);
        return headNode;
    }

    public void recurse(Node head){
        if(head == null){
            return;
        }
        Node node = new Node(head.val);
        node.prev = prevNode;
        if(prevNode != null){
            prevNode.next = node;
        }
        prevNode = node;
        if(headNode == null){
            headNode = node;
        }
        if(head.child != null){
            Node temp = head.next;
            recurse(head.child);
            recurse(temp);
        } else {
            recurse(head.next);
        }
        return;
    }
}