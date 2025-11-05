class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 0; i < tickets.length; i++){
            queue.add(i);
        }
        int ans = 0;
        while(tickets[k] > 0){
            int idx = queue.poll();
            tickets[idx]--;
            if(tickets[idx] > 0){
                queue.add(idx);
            }
            ans++;
        }
        return ans;
    }
}