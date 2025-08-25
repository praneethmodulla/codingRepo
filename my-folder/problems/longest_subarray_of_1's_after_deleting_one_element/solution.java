class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxLen = 0;
        for(right = 0; right < nums.length; right++){
            if(nums[right] == 1){
                maxLen = Math.max(right - left + 1 - count, maxLen);
            } else if(nums[right] == 0){
                count += 1;
                while(count > 1){
                    if(nums[left] == 0){
                        count--;
                    }
                    left++;
                }
            }
        }
        if(maxLen == nums.length){
            maxLen = maxLen - 1;
        }
        return maxLen;
    }
}