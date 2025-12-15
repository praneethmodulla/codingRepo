class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)-> {
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for(int i = 0; i < intervals.length; i++){
            heap.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        int count = 0;
        int[] prev = heap.poll();
        while(!heap.isEmpty()){
            int[] var = heap.poll();
            if(var[0] < prev[1]){
                count++;
                if(var[1] < prev[1]){
                    prev[1] = var[1];
                }
            } else {
                prev[0] = var[0];
                prev[1] = var[1];
            }
        }
        return count;
    }
}