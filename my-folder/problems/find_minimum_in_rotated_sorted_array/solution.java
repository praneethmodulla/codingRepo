class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] < min){
                min = nums[mid];
            }
            if(nums[low] <= nums[mid] && nums[low] <= nums[high]){
                high = mid - 1;
            } else if(nums[mid] >= nums[high] && nums[high] <= nums[low]){
                low = mid + 1;
            } else if(nums[mid] <= nums[low] && nums[mid] <= nums[high]){
                low = low + 1;
                high = high - 1;
            }
        }
        return min;
    }
}