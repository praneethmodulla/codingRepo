class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] dummyNum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                dummyNum[i] = 1;
            } else {
                dummyNum[i] = 0;
            }
        }
        return func(dummyNum, k) - func(dummyNum, k - 1);
    }

    public int func(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int leftPtr = 0;
        int rightPtr = 0;
        int cnt = 0;
        int sum = 0;
        for(rightPtr = 0; rightPtr < nums.length; rightPtr++){
            sum += nums[rightPtr];
            while(sum > k){
                sum -= nums[leftPtr];
                leftPtr++;
            }
            cnt += (rightPtr - leftPtr + 1);
        }
        return cnt;
    }
}