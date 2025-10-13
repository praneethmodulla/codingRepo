class Solution {
    public int shortestPathLength(int[][] graph) {
        if(graph.length == 1){
            return 0;
        }
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        ArrayList<int[]> queue = new ArrayList<int[]>();
        boolean[][] seen = new boolean[n][endingMask];
        for(int i = 0; i < n; i++){
            seen[i][1 << i] = true;
            queue.add(new int[]{i, 1 << i});
        }
        int steps = 0;
        while(!queue.isEmpty()){
            ArrayList<int[]> nextQueue = new ArrayList<int[]>();
            for(int i = 0; i < queue.size(); i++){
                int currentNode = queue.get(i)[0];
                int currentMask = queue.get(i)[1];
                for(int j = 0; j < graph[currentNode].length; j++){
                    if((currentMask | (1 << graph[currentNode][j])) == endingMask){
                        return 1 + steps;
                    }
                    if(!seen[graph[currentNode][j]][currentMask | (1 << graph[currentNode][j])]){
                        seen[graph[currentNode][j]][currentMask | (1 << graph[currentNode][j])] = true;
                        nextQueue.add(new int[]{graph[currentNode][j], currentMask | (1 << graph[currentNode][j])});
                    }
                }
            }
            steps++;
            queue = nextQueue;
        }
        return -1;
    }
}