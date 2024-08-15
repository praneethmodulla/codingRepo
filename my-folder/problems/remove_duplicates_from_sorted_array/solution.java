class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        for(j = 0; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                if(i != j){
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }
}