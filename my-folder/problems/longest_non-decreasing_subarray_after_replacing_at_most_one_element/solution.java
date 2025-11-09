class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] <= nums[i]){
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(nums[i + 1] >= nums[i]){
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                ans = Math.max(ans, right[i + 1] + 1);
            } else if(i == n - 1){
                ans = Math.max(ans, left[i - 1] + 1);
            } else if(nums[i - 1] <= nums[i + 1]){
                ans = Math.max(ans, left[i - 1] + right[i + 1] + 1);
            } else {
                ans = Math.max(ans, Math.max(left[i - 1], right[i + 1]) + 1);
            }
        }
        return ans;
    }
}