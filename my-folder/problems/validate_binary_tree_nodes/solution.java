class Pair {
    int node;
    Pair leftChild;
    Pair rightChild;
    Pair parent;
    public Pair(int node, Pair left, Pair right, Pair parent){
        this.node = node;
        this.leftChild = left;
        this.rightChild = right;
        this.parent = parent;
    }
}
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Pair> hMap = new HashMap<Integer, Pair>();
        for(int i = 0; i < n; i++){
            hMap.put(i, new Pair(i, null, null, null));
        }
        for(int i = 0; i < n; i++){
            
            Pair left = null;
            Pair right = null;
            if(leftChild[i] != -1){
                left = hMap.get(leftChild[i]);
            }
            if(rightChild[i] != -1){
                right = hMap.get(rightChild[i]);
            }
            Pair parent = hMap.get(i);
            if(parent.parent != null && (parent.parent == left || parent.parent == right)){
                return false;
            }
            if(left != null && left.parent != null){
                return false;
            }
            if(right != null && right.parent != null){
                return false;
            }
            parent.leftChild = left;
            parent.rightChild = right;
            if(left != null){
                left.parent = parent;
            }
            if(right != null){
                right.parent = parent;
            }
        }
        int cnt = 0;
        int root = 0;
        for(int i : hMap.keySet()){
            if(hMap.get(i).parent == null){
                cnt++;
                root = i;
            }
            if(cnt > 1){
                return false;
            }
        }
        if(cnt == 0){
            return false;
        }
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        boolean check = recurse(hMap.get(root), vis);
        for(int i = 0; i < n; i++){
            if(vis[i] != 1){
                return false;
            }
        }
        if(!check){
            return false;
        }
        return true;
    }

    public boolean recurse(Pair node, int[] vis){
        if(node == null){
            return true;
        }
        if(vis[node.node] == 1){
            return false;
        }
        vis[node.node] = 1;
        return recurse(node.leftChild, vis) && recurse(node.rightChild, vis);
    }
}