class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != j && nums[i] == nums[j]){
                continue;
            } else if(i != j && nums[i] != nums[j]){
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return ++j;
    }
}