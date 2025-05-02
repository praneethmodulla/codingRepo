class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<Boolean>();
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0; i < queries.length; i++){
            if(check(queries[i][0], queries[i][1], adjList, new int[numCourses])){
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public boolean check(int node1, int node2, List<List<Integer>> adj, int[] vis){
        if(node1 == node2){
            return true;
        }
        vis[node1] = 1;
        List<Integer> nodes = adj.get(node1);
        for(int i = 0; i < nodes.size(); i++){
            if(vis[nodes.get(i)] != 1){
                if(check(nodes.get(i), node2, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}