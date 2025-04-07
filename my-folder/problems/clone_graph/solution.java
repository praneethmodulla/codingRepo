/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> hMap = new HashMap<Node, Node>();
        recurse(hMap, node);
        for(Node n : hMap.keySet()){
            Node clone = hMap.get(n);
            for(int i = 0; i < n.neighbors.size(); i++){
                clone.neighbors.add(hMap.get(n.neighbors.get(i)));
            }
        }
        return hMap.get(node);
    }

    public void recurse(HashMap<Node, Node>hMap, Node node){
        if(node == null){
            return;
        }
        if(hMap.containsKey(node)){
            return;
        }
        Node newNode = new Node(node.val);
        hMap.put(node, newNode);
        for(int i = 0; i < node.neighbors.size(); i++){
            recurse(hMap, node.neighbors.get(i));
        }
        return;
    }
}