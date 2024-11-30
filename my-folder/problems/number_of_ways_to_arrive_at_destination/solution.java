class Pair {
    int node;
    long time;
    public Pair(int _node, long _time){
        node = _node;
        time = _time;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<List<Pair>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < roads.length; i++){
            adjList.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adjList.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x, y) -> (int)(x.time - y.time));
        queue.add(new Pair(0, 0));
        long[] nodes = new long[n];
        nodes[0] = 0;
        Arrays.fill(nodes, Long.MAX_VALUE);
        long[] numWays = new long[n];
        Arrays.fill(numWays, 0);
        numWays[0] = 1;
        int m = (int)(1e9 + 7);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int node = pair.node;
            long time = pair.time;
            List<Pair> adjNodes = adjList.get(node);
            for(int i = 0; i < adjNodes.size(); i++){
                int nodeVal = adjNodes.get(i).node;
                long timeVal = adjNodes.get(i).time;
                if(nodes[nodeVal] > time + timeVal){
                    nodes[nodeVal] = time + timeVal;
                    queue.add(new Pair(nodeVal, time + timeVal));
                    numWays[nodeVal] = numWays[node];
                } else if(nodes[nodeVal] == time + timeVal){
                    numWays[nodeVal] = (numWays[nodeVal] + numWays[node])%m;
                }
            }
        }
        return (int)numWays[n - 1] % m;
    }
}