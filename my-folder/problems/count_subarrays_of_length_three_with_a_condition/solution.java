class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int left = 0;
        for(left = 0; left < nums.length - 2; left++){
            if((double)(nums[left] + nums[left + 2]) == (double)nums[left + 1]/2){
                count++;
            }
        }
        return count;
    }
}