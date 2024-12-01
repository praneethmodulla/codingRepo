class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        recurse(graph, result, 0, set);
        return result;
    }

    public void recurse(int[][] graph, List<List<Integer>> result, int node, List<Integer> path){
        path.add(node);
        if(node == graph.length - 1){
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        for(int i = 0; i < graph[node].length; i++){
            recurse(graph, result, graph[node][i], path);
        }
        path.remove(path.size() - 1);
        return;
    }

}