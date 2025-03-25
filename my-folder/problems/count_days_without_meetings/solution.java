class Solution {
    public int countDays(int days, int[][] meetings) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < meetings.length; i++){
            minHeap.add(new int[]{meetings[i][0], meetings[i][1]});
        }
        int ans = 0;
        int[] prev = minHeap.poll();
        ans += prev[0] - 1;
        while(!minHeap.isEmpty()){
            int[] meeting = minHeap.poll();
            if(meeting[0] <= prev[1]){
                if(prev[1] < meeting[1]){
                    prev[1] = meeting[1];
                }
            } else {
                ans += meeting[0] - prev[1] - 1;
                prev[1] = meeting[1];
            }
        }
        if(days > prev[1]){
            ans += days - prev[1];
        }
        return ans;
    }
}