class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int startIdx = 0;
        int rightPtr = 2;
        int diff = nums[1] - nums[0];
        int cnt = 0;
        for(rightPtr = 2; rightPtr < nums.length; rightPtr++){
            if(diff != nums[rightPtr] - nums[rightPtr - 1]){
                startIdx = rightPtr - 1;
                diff = nums[rightPtr] - nums[rightPtr - 1];
            } else if(diff == nums[rightPtr] - nums[rightPtr - 1]){
                if(rightPtr - startIdx + 1 == 3){
                    cnt += 1;
                } else if(rightPtr - startIdx + 1 > 3){
                    int minWindow = rightPtr - 2;
                    cnt += 1;
                    cnt += minWindow - startIdx;
                }
            }
        }
        return cnt;
    }
}