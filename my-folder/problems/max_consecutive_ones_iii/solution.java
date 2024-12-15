class Solution {
    public int longestOnes(int[] nums, int k) {
        int leftPtr = 0;
        int rightPtr = 0;
        int cnt = 0;
        int maxLen = 0;
        for(rightPtr = 0; rightPtr < nums.length; rightPtr++){
            while(cnt >= k && nums[rightPtr] == 0){
                if(nums[leftPtr] == 0){
                    cnt--;
                }
                leftPtr++;
            }
            if(nums[rightPtr] == 0 && cnt < k){
                cnt++;
            }
            if(maxLen < rightPtr - leftPtr + 1){
                maxLen = rightPtr - leftPtr + 1;
            }
        }
        return maxLen;
    }
}