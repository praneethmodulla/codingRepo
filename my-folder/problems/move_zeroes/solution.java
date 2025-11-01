class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[i] == 0){
                if(i == j){
                    j++;
                } else {
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        i++;
                        nums[j] = 0;
                    }
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        return;
    }
}