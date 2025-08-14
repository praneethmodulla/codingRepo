class Solution {
    public int sortPermutation(int[] nums) {
        int result = -1;
        for(int i = 0; i < nums.length; i++){
            if(i == nums[i]){
                continue;
            }
            if(result == -1){
                result = nums[i];
            } else {
                result = result & nums[i];
            }
        }
        if(result == -1){
            return 0;
        }
        return result;
    }
}