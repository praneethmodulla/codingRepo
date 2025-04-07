class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> nodes = adj.get(node);
            for(int i = 0; i < nodes.size(); i++){
                indegree[nodes.get(i)]--;
                if(indegree[nodes.get(i)] == 0){
                    queue.add(nodes.get(i));
                }
            }
        }
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] > 0){
                return false;
            }
        }
        return true;
    }
}