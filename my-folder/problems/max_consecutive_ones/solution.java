class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int freq = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 1){
                if(maxCount < freq){
                    maxCount = freq;
                }
                freq = 0;
            }
            if(nums[i] == 1){
                freq += 1;
            }
        }
        if(maxCount < freq){
            maxCount = freq;
        }
        return maxCount;
    }
}