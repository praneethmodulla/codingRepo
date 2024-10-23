class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numProvinces = 0;
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> nodes = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    nodes.add(j);
                }
            }
            adj.add(nodes);
        }
        
        int[] vis = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                numProvinces++;
                recurse(vis, adj, i);
            }
        }
        return numProvinces;
    }

    public void recurse(int[] vis, ArrayList<ArrayList<Integer>> adj, int node){
        vis[node] = 1;
        ArrayList<Integer> nodes = adj.get(node);
        for(int i = 0; i < nodes.size(); i++){
            if(vis[nodes.get(i)] != 1){
                recurse(vis, adj, nodes.get(i));
            }
        }
        return;
    }
}