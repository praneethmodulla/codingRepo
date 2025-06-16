class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1){
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for(right = 0; right < nums.length; right++){
            if(right - left + 1 == k){
                if(nums[right] - nums[left] < minDiff){
                    minDiff = nums[right] - nums[left];
                }
                left++;
            }
        }
        return minDiff;
    }
}