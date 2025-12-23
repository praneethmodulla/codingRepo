class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)-> Integer.compare(a[0], b[0]));
        for(int i = 0; i < events.length; i++){
            heap.add(new int[]{events[i][0], events[i][1], events[i][2]});
        }
        int[][] orderedEvents = new int[events.length][3];
        int i = 0;
        while(!heap.isEmpty()){
            int[] event = heap.poll();
            orderedEvents[i][0] = event[0];
            orderedEvents[i][1] = event[1];
            orderedEvents[i][2] = event[2];
            i++;
        }
        int[][] dp = new int[events.length][3];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(orderedEvents, 0, 2, dp);
    }

    public int recurse(int[][] orderedEvents, int idx, int k, int[][] dp){
        if(idx >= orderedEvents.length || k == 0){
            return 0;
        }
        if(dp[idx][k] == -1){
            int end = orderedEvents[idx][1];
            int lo = idx + 1;
            int high = orderedEvents.length - 1;
            while(lo < high){
                int mid = lo + (high - lo)/2;
                if(orderedEvents[mid][0] > end){
                    high = mid;
                } else {
                    lo = mid + 1;
                }
            }
            int take = orderedEvents[idx][2] + (lo < orderedEvents.length && orderedEvents[lo][0] > end ? recurse(orderedEvents, lo, k - 1, dp) : 0);
            int notTake = recurse(orderedEvents, idx + 1, k, dp);
            dp[idx][k] = Math.max(take, notTake);
        }
        return dp[idx][k];
    }
}