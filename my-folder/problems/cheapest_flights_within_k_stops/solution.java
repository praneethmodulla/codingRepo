class Pair {
    int node;
    int cost;
    public Pair(int _node, int _cost){
        node = _node;
        cost = _cost;
    }
}
class tuple {
    int node;
    int cost;
    int stop;
    public tuple(int _node, int _cost, int _stop){
        node = _node;
        cost = _cost;
        stop = _stop;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<List<Pair>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < flights.length; i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] costArray = new int[n];
        Arrays.fill(costArray, Integer.MAX_VALUE);
        Queue<tuple> queue = new LinkedList<tuple>();
        queue.add(new tuple(src, 0, 0));
        while(!queue.isEmpty()){
            tuple tup = queue.poll();
            int node = tup.node;
            int cost = tup.cost;
            int numStops = tup.stop;
            List<Pair> adjNodes = adjList.get(node);
            for(int i = 0; i < adjNodes.size(); i++){
                if(numStops + 1 <= k + 1 && adjNodes.get(i).cost + cost < costArray[adjNodes.get(i).node]){
                    queue.add(new tuple(adjNodes.get(i).node, cost + adjNodes.get(i).cost, numStops + 1));
                    costArray[adjNodes.get(i).node] = adjNodes.get(i).cost + cost;
                }
            }
        }
        if(costArray[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return costArray[dst];
    }
}