class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                result[i] = nums[i];
            } else if(nums[i] > 0){
                int newIdx = (i + nums[i])%len;
                result[i] = nums[newIdx];
            } else if(nums[i] < 0){
                int absVal = Math.abs(nums[i]);
                int newIdx = i - absVal;
                while(newIdx < 0){
                    newIdx = len + newIdx;
                }
                result[i] = nums[newIdx];
            }
        }
        return result;
    }
}