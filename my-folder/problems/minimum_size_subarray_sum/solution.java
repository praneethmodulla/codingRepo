class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int leftPtr = 0;
        int rightPtr = 0;
        int sum = 0;
        int minLen = 0;
        int len = Integer.MAX_VALUE;
        for(rightPtr = 0; rightPtr < nums.length; rightPtr++){
            sum += nums[rightPtr];
            if(sum < target){
                continue;
            }
            while(sum > target){
                sum -= nums[leftPtr];
                leftPtr++;
            }
            if (sum == target){
                if(len > rightPtr - leftPtr + 1){
                    len = rightPtr - leftPtr + 1;
                }
            } else if(sum < target){
                sum += nums[leftPtr - 1];
                leftPtr--;
                if(len > rightPtr - leftPtr + 1){
                    len = rightPtr - leftPtr + 1;
                }
            }
        }
        if(len == Integer.MAX_VALUE){
            return minLen;
        }
        return len;
    }
}