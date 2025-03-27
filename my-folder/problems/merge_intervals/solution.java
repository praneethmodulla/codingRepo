class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length; i++){
            heap.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        int[] prev = heap.poll();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(!heap.isEmpty()){
            int[] var = heap.poll();
            if(var[0] <= prev[1]){
                if(var[1] > prev[1]){
                    prev[1] = var[1];
                }
            } else {
                ArrayList<Integer> res = new ArrayList<Integer>();
                res.add(prev[0]);
                res.add(prev[1]);
                result.add(res);
                prev[0] = var[0];
                prev[1] = var[1];
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(prev[0]);
        res.add(prev[1]);
        result.add(res);
        int[][] answer = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            answer[i][0] = result.get(i).get(0);
            answer[i][1] = result.get(i).get(1);
        }
        return answer;
    }
}