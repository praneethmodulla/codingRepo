class Pair {
    int node;
    int weight;
    public Pair(int _n, int _weight){
        this.node = _n;
        this.weight = _weight;
    }
}
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Pair>> adjList = new ArrayList<List<Pair>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < connections.length; i++){
            adjList.get(connections[i][0]).add(new Pair(connections[i][1], -1));
            adjList.get(connections[i][1]).add(new Pair(connections[i][0], 1));
        }
        int[] vis = new int[n];
        Arrays.fill(vis, 0);
        int[] min = new int[1];
        recurse(adjList, 0, min, vis);
        return min[0];
    }

    public void recurse(List<List<Pair>> adjList, int node, int[] min, int[] vis){
        if(vis[node] == 1){
            return;
        }
        vis[node] = 1;
        List<Pair> con = adjList.get(node);
        for(int i = 0; i < con.size(); i++){
            if(con.get(i).weight == -1 && vis[con.get(i).node] != 1){
                min[0]++;
            }
            recurse(adjList, con.get(i).node, min, vis);
        }
        return;
    }
}