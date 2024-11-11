/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node temp = head;
        Node copyHead = null;
        boolean firstNode = true;
        Node prevNode = null;
        while(temp != null){
            Node node = new Node(temp.val);
            if(firstNode){
                firstNode = false;
                copyHead = node;
                prevNode = node;
            } else {
                prevNode.next = node;
                prevNode = prevNode.next;
            }
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node cpyTemp = map.get(temp);
            if(temp.random == null){
                cpyTemp.random = null;
            } else {
                Node node = temp.random;
                Node cpyNode = map.get(node);
                cpyTemp.random = cpyNode;
            }
            temp = temp.next;
        }
        return copyHead;
    }
}