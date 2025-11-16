class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(max1 <= nums[i]){
                max2 = max1;
                max1 = nums[i];
            }
            if(nums[i] < max1 && nums[i] > max2){
                max2 = nums[i];
            }
            if(min1 > nums[i]){
                min1 = nums[i];
            }
        }
        int max = max1 + max2 - min1;
        return max;
    }
}