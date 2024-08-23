class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(low == high){
                return nums[mid];
            }
            if(nums[mid] < nums[low] && nums[mid] < nums[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[mid];
    }
}