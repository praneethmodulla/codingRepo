class Solution {
    public int treeDiameter(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        int numNodes = edges.length + 1;
        for(int i = 0; i < numNodes; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int[] diameter = new int[1];
        int[] max = new int[numNodes];
        Arrays.fill(max, -1);
        recurse(adjList, max, 0, diameter);
        return diameter[0];
    }

    public int recurse(List<List<Integer>> adj, int[] max, int node, int[] diameter){
        if(max[node] != -1){
            return max[node];
        }
        max[node] = 0;
        List<Integer> connect = adj.get(node);
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < connect.size(); i++){
            int depth = recurse(adj, max, connect.get(i), diameter);
            if(depth > max1){
                max2 = max1;
                max1 = depth;
            } else if(depth <= max1 && depth > max2){
                max2 = depth;
            }
        } 
        diameter[0] = Math.max(diameter[0], max1 + max2);
        return max[node] = Math.max(max1, max2) + 1;
    }
}