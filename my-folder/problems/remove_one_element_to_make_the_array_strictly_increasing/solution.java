class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                continue;
            } else {
                if(i - 2 >= 0 && i + 1 < nums.length){
                    if(nums[i - 2] < nums[i] || nums[i - 1] < nums[i + 1]){
                        cnt++;
                    } else {
                        return false;
                    }
                } else if(i - 2 < 0 && i + 1 < nums.length){
                    if(nums[i - 1] < nums[i + 1] || nums[i] < nums[i + 1]){
                        cnt++;
                    } else {
                        return false;
                    }
                } else if(i - 2 >= 0 && i + 1 == nums.length){
                    cnt++;
                }
                if(cnt > 1){
                    return false;
                }
            }
        }
        return true;
    }
}