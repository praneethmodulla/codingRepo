class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[i] != 0){
                i++;
            } else {
                if(i != j && nums[j] != 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
            }
        }
        return;
    }
}