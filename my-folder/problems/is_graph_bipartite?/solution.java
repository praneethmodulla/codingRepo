class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] nodes = new int[graph.length];
        Arrays.fill(nodes, -1);
        for(int i = 0; i < graph.length; i++){
            if(nodes[i] == -1){
                boolean check = recurse(graph, nodes, i, 1);
                if(!check){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean recurse(int[][] graph, int[] nodes, int node, int parentVal){
        int childVal = 0;
        if(parentVal == 0){
            childVal = 1;
        }
        for(int i = 0; i < graph[node].length; i++){
            if(nodes[graph[node][i]] == -1){
                nodes[graph[node][i]] = childVal;
                boolean check = recurse(graph, nodes, graph[node][i], childVal);
                if(!check){
                    return false;
                }
            } else {
                if(nodes[graph[node][i]] != childVal){
                    return false;
                }
            }
        }
        return true;
    }
}