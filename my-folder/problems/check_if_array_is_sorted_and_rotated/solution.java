class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(i == 0 && nums[i] < nums[nums.length - 1]){
                cnt += 1;
            } 
            if(nums[i] > nums[i + 1]){
                cnt += 1;
            }
            if(cnt > 1){
                return false;
            }
        }
        return true;
    }
}