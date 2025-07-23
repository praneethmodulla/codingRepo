class Pair{
    int manager;
    int time;
    public Pair(int manage, int timeTaken){
        manager = manage;
        time = timeTaken;
    }
}
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < manager.length; i++){
            if(manager[i] == -1){
                continue;
            }
            adj.get(manager[i]).add(i);
        }
        int timeTaken = 0;
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(headID, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int time = p.time;
            int head = p.manager;
            timeTaken = Math.max(timeTaken, time);
            List<Integer> sub = adj.get(head);
            for(int i = 0; i < sub.size(); i++){
                queue.add(new Pair(sub.get(i), time + informTime[head]));
            }
        }
        return timeTaken;
    }
}