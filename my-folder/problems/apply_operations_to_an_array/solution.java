class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                continue;
            }
            nums[i] *= 2;
            nums[i + 1] = 0;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == j && nums[j] != 0){
                j++;
            } else if(i == j && nums[j] == 0){
                continue;
            } else if(i != j && nums[i] != 0){
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
        return nums;
    }
}