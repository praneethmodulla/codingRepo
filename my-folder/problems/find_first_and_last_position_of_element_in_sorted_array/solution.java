class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] < target){
                low = mid + 1;
            } else {
                if(mid < nums.length && nums[mid] == target){
                    res[0] = mid;
                }
                high = mid - 1;
            }
        }
        if(res[0] == -1){
            return res;
        }
        low = 0;
        high = nums.length - 1;
        mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] <= target){
                if(mid < nums.length && nums[mid] == target){
                    res[1] = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}