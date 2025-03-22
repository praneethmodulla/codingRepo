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
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> set = new HashSet<Node>();
        Node temp1 = p;
        Node temp2 = q;
        while(temp1.parent != null){
            set.add(temp1);
            temp1 = temp1.parent;
        }
        while(temp2.parent != null){
            if(set.contains(temp2)){
                return temp2;
            }
            temp2 = temp2.parent;
        }
        return temp1;
    }
}