class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] vis = new int[n];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int conn = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] != 1){
                conn++;
                recurse(adjList, vis, i);
            }
        }
        return conn;
    }
    public void recurse(List<List<Integer>> adjList, int[] vis, int node){
        if(vis[node] == 1){
            return;
        }
        List<Integer> nodes = adjList.get(node);
        vis[node] = 1;
        for(int i = 0; i < nodes.size(); i++){
            recurse(adjList, vis, nodes.get(i));
        }
        return;
    }
}