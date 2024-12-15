class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums, goal) - func(nums, goal - 1);
    }

    public int func(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }
        int leftPtr = 0;
        int rightPtr = 0;
        int sum = 0;
        int cnt = 0;
        for(rightPtr = 0; rightPtr < nums.length; rightPtr++){
            sum += nums[rightPtr];
            while(sum > goal){
                sum -= nums[leftPtr];
                leftPtr++;
            }
            cnt += (rightPtr - leftPtr + 1);
        }
        return cnt;
    }
}