class Solution {
    public int minOperations(int[] nums, int k) {
        int modSum = 0;
        for(int i = 0; i < nums.length; i++){
            modSum += nums[i] % k;
        }
        return modSum % k;
    }
}