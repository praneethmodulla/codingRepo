class Solution {
    public int maximumCount(int[] nums) {
        int numPositive = 0;
        int numNegative = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                numPositive++;
            } else if(nums[i] < 0){
                numNegative++;
            }
        }
        return Math.max(numPositive, numNegative);
    }
}