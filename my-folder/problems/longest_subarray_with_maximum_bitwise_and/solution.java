class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = nums[0];
        int ans = nums[0];
        int length = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++){
            ans = Math.max(ans & nums[i], nums[i]);
            if(ans == maxVal){
                length++;
                maxLen = Math.max(maxLen, length);
            } else if(ans > maxVal){
                maxVal = ans;
                length = 1;
                maxLen = length;
            } else {
                length = 0;
            }
        }
        return maxLen;
    }
}