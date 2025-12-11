class Solution {
    public int maxEvents(int[][] events) {
        int maxDay = 0;
        for(int i = 0; i < events.length; i++){
            maxDay = Math.max(maxDay, events[i][1]);
        }
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        for(int i = 1, j = 0 ; i <= maxDay; i++){
            while(j < events.length && events[j][0] <= i){
                pq.add(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}