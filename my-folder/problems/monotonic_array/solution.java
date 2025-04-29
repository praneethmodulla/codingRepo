class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false;
        boolean dec = false;
        int initial = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                continue;
            } else {
                if(nums[i] > nums[i - 1]){
                    inc = true;
                } else {
                    dec = true;
                }
            }
        }
        if(dec == true && inc == true){
            return false;
        }
        return true;
    }
}