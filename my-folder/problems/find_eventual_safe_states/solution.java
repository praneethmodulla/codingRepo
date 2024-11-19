class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        int[] indegree = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                adjList.get(graph[i][j]).add(i);
            }
        }
        for(int i = 0; i < adjList.size(); i++){
            for(int j = 0; j < adjList.get(i).size(); j++){
                indegree[adjList.get(i).get(j)]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> safeNodes = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            List<Integer> nodes = adjList.get(node);
            for(int i = 0; i < nodes.size(); i++){
                indegree[nodes.get(i)]--;
                if(indegree[nodes.get(i)] == 0){
                    queue.add(nodes.get(i));
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}