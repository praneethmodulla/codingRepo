class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(i != j && nums[j] == nums[i]){
                continue;
            } else if(i != j && nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return ++i;
    }
}