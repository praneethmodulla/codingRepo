class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int num = 0;
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0; i < isConnected.length; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        for(int i = 0; i < adj.size(); i++){
            if(vis[i] != 1){
                num++;
                recurse(adj, vis, i);
            }
        }
        return num;
    }
    public void recurse(List<List<Integer>> adj, int[] vis, int node){
        if(vis[node] == 1){
            return;
        }
        vis[node] = 1;
        List<Integer> nodes = adj.get(node);
        for(int i = 0; i < nodes.size(); i++){
            if(vis[nodes.get(i)] != 1){
                recurse(adj, vis, nodes.get(i));
            }
        }
        return;
    }
}