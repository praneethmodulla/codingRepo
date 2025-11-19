class Solution {
    public int dominantIndex(int[] nums) {
        int maxIdx = -1;
        int max2 = -1;
        for(int i = 0; i < nums.length; i++){
            if(maxIdx == -1 || nums[maxIdx] < nums[i]){
                max2 = maxIdx;
                maxIdx = i;
            } else if(max2 == -1 || nums[max2] < nums[i]){
                max2 = i;
            }
        }
        if(nums[maxIdx] >= 2 * nums[max2]){
            return maxIdx;
        }
        return -1;
    }
}