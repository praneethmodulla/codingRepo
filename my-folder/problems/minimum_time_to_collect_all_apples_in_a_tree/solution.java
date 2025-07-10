class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        int[] vis = new int[hasApple.size()];
        for(int i = 0; i < hasApple.size(); i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return recurse(adj, vis, hasApple, 0);
    }

    public int recurse(List<List<Integer>> adj, int[] vis, List<Boolean> hasApple, int node){
        vis[node] = 1;
        int childTime = 0; int totalTime = 0;
        for(int i : adj.get(node)){
            if(vis[i] == 1){
                continue;
            }
            childTime = recurse(adj, vis, hasApple, i);

            if(childTime > 0 || hasApple.get(i)){
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}