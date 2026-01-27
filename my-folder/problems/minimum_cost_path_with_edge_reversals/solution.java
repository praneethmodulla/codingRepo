class Pair {
    int node;
    int cost;
    public Pair(int _node, int _cost){
        this.node = _node;
        this.cost = _cost;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<List<Pair>>();
        for(int i = 0 ; i < n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0], 2 * edges[i][2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b) -> Integer.compare(a.cost, b.cost));
        queue.add(new Pair(0, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.node;
            int cost = p.cost;
            if(node == n - 1){
                return cost;
            }
            if(cost > dist[node]){
                continue;
            }
            List<Pair> conn = adjList.get(node);
            for(int i = 0; i < conn.size(); i++){
                if(cost + conn.get(i).cost < dist[conn.get(i).node]){
                    dist[conn.get(i).node] = cost + conn.get(i).cost;
                    queue.add(new Pair(conn.get(i).node, cost + conn.get(i).cost));
                }
            }
        }
        return -1;
    }
}