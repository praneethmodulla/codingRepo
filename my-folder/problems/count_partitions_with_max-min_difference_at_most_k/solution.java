class Solution {
    public int countPartitions(int[] nums, int k) {
        int mod = (int)1e9 + 7;
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        Deque<Integer> maxQ = new LinkedList<Integer>();
        Deque<Integer> minQ = new LinkedList<Integer>();
        dp[0] = 1;
        prefix[0] = 1;
        for(int i = 0, j = 0; i < n; i++){
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]){
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            while(!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]){
                minQ.pollLast();
            }
            minQ.offerLast(i);
            while(!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k){
                if(maxQ.peekFirst() == j){
                    maxQ.pollFirst();
                }
                if(minQ.peekFirst() == j){
                    minQ.pollFirst();
                }
                j++;
            }
            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }
        return (int)dp[n];
    }
}