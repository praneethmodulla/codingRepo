class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[numCourses];
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int idx = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            res[idx++] = course;
            List<Integer> courses = adj.get(course);
            for(int i = 0; i < courses.size(); i++){
                indegree[courses.get(i)]--;
                if(indegree[courses.get(i)] == 0){
                    queue.add(courses.get(i));
                }
            }
        }
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] != 0){
                return new int[0];
            }
        }
        return res;
    }
}