class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] ksum = new long[k];
        for(int i = 0; i < ksum.length; i++){
            ksum[i] = Long.MAX_VALUE/2;
        }
        long prefixSum = 0;
        long max = Long.MIN_VALUE;
        ksum[k - 1] = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int grp = i % k;
            max = Math.max(max, prefixSum - ksum[grp]);
            ksum[grp] = Math.min(ksum[grp], prefixSum);
        }
        return max;
    }
}