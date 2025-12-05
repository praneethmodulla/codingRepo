class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int leftSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            leftSum += nums[i];
            int rightSum = sum - leftSum;
            int diff = leftSum - rightSum;
            if(diff % 2 == 0 && rightSum > 0){
                count++;
            }
        }
        return count;
    }
}