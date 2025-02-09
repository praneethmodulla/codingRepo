class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for(i = 0; i < nums.length; i++){
            if(i == j && nums[i] != 0){
                j++;
            } else if(i != j && nums[i] != 0){
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
        return;
    }
}