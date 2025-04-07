class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis = new int[n];
        boolean cycle = recurse(adjList, vis, 0, -1);
        if(!cycle){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(vis[i] != 1){
                return false;
            }
        }
        return true;
    }

    public boolean recurse(List<List<Integer>> adj, int[] vis, int node, int parentNode){
        if(vis[node] == 1){
            return false;
        }
        vis[node] = 1;
        List<Integer> nodes = adj.get(node);
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i) != parentNode){
                if(!recurse(adj, vis, nodes.get(i), node)){
                    return false;
                }
            }
        }
        return true;
    }
}