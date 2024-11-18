class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < adjList.size(); i++){
            List<Integer> nodes = adjList.get(i);
            for(int j = 0; j < nodes.size(); j++){
                indegree[nodes.get(j)]++;
            }
        } 
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        if(queue.isEmpty()){
            return false;
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> nodes = adjList.get(node);
            for(int i = 0; i < nodes.size(); i++){
                indegree[nodes.get(i)]--;
                if(indegree[nodes.get(i)] == 0){
                    queue.add(nodes.get(i));
                }
            }
        }
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}