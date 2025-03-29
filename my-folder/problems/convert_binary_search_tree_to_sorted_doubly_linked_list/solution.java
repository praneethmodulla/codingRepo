/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        Node head = null;
        Node prev = null;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node node = root;
        while(!stack.isEmpty()){
            while(node != null && node.left != null){
                stack.push(node.left);
                node = node.left;
            }
            node = stack.pop();
            if(head == null){
                head = node;
            }
            if(prev != null){
                prev.right = node;
            }
            prev = node;
            node = node.right;
            if(node != null){
                stack.push(node);
            }
        }
        Node temp = head;
        while(temp.right != null){
            Node next = temp.right;
            next.left = temp;
            temp = temp.right;
        }
        temp.right = head;
        head.left = temp;
        return head;
    }
}