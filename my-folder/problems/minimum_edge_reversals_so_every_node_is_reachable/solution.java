class Pair {
    int node;
    int weight;
    public Pair(int _n, int _weight){
        this.node = _n;
        this.weight = _weight;
    }
}
class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<List<Pair>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], 0));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0], 1));
        }
        int[] result = new int[n];
        int[] vis = new int[n];
        Arrays.fill(vis, 0);
        int[] min = new int[1];
        recurse(0, vis, min, adjList);
        result[0] = min[0];
        Arrays.fill(vis, 0);
        reroot(0, vis, result, adjList);
        return result;
    }

    public void recurse(int node, int[] vis, int[] min, List<List<Pair>> adjList){
        if(vis[node] == 1){
            return;
        }
        vis[node] = 1;
        List<Pair> con = adjList.get(node);
        for(int i = 0; i < con.size(); i++){
            if(vis[con.get(i).node] != 1){
                if(con.get(i).weight == 1){
                    min[0]++;
                }
                recurse(con.get(i).node, vis, min, adjList);
            }
        }
        return;
    }

    public void reroot(int node, int[] vis, int[] result, List<List<Pair>> adjList){
        vis[node] = 1;
        List<Pair> con = adjList.get(node);
        for(int i = 0; i < con.size(); i++){
            int nextNode = con.get(i).node;
            if(vis[nextNode] != 1){
                result[nextNode] = result[node] + 1 - (2 * con.get(i).weight);
                reroot(nextNode, vis, result, adjList);
            }
        }
        return;
    }
}