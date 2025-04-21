/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right != null){
            Node successor = node.right;
            while(successor.left != null){
                successor = successor.left;
            }
            return successor;
        }
        while(node.parent != null && node.parent.val <= node.val){
            node = node.parent;
        }
        return node.parent;
    }
}