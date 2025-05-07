class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length; i++){
            queue.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        queue.add(new int[]{newInterval[0], newInterval[1]});
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int[] prev = queue.poll();
        while(!queue.isEmpty()){
            int[] var = queue.poll();
            if(var[0] <= prev[1]){
                if(var[1] > prev[1]){
                    prev[1] = var[1];
                }
            } else {
                List<Integer> res = new ArrayList<Integer>();
                res.add(prev[0]);
                res.add(prev[1]);
                result.add(res);
                prev[0] = var[0];
                prev[1] = var[1];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(prev[0]);
        res.add(prev[1]);
        result.add(res);
        int[][] ans = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }
}