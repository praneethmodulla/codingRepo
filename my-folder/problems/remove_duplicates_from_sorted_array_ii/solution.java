class Solution {
    public int removeDuplicates(int[] nums) {
        int lp = 2;
        int rp = 2;
        for(rp = 2; rp < nums.length; rp++){
            if(nums[rp] != nums[lp - 2]){
                nums[lp] = nums[rp];
                lp++;
            }
        }
        return lp;
    }
}