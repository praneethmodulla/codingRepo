class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k > 0){
            int minIdx = 0;
            for(int i = 1; i < nums.length; i++){
                if(nums[minIdx] > nums[i]){
                    minIdx = i;
                }
            }
            nums[minIdx] = nums[minIdx] * multiplier;
            k--;
        }
        return nums;
    }
}