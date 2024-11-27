class Pair {
    int node;
    int time;
    public Pair(int _node, int _time){
        node = _node;
        time = _time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<List<Pair>>();
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < times.length; i++){
            adjList.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int[] nodes = new int[n + 1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        nodes[k] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x, y) -> x.time - y.time);
        queue.add(new Pair(k, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int node = pair.node;
            int time = pair.time;
            List<Pair> adjNodes = adjList.get(node);
            for(int i = 0; i < adjNodes.size(); i++){
                if(nodes[adjNodes.get(i).node] > time + adjNodes.get(i).time){
                    nodes[adjNodes.get(i).node] = time + adjNodes.get(i).time;
                    queue.add(new Pair(adjNodes.get(i).node, time + adjNodes.get(i).time));
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < nodes.length; i++){
            if(nodes[i] == Integer.MAX_VALUE){
                return -1;
            }
            if(ans < nodes[i]){
                ans = nodes[i];
            }
        }
        return ans;
    }
}