class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return range(mid, nums);
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] range(int mid, int[] nums){
        int[] res = new int[]{-1, -1};
        int i = mid;
        int j = mid;
        while(i >= 0){
            if(nums[i] == nums[mid]){
                i--;
            } else {
                res[0] = i + 1;
                break;
            }
        }
        if(res[0] == -1){
            res[0] = i + 1;
        }
        while(j < nums.length){
            if(nums[j] == nums[mid]){
                j++;;
            } else {
                res[1] = j - 1;
                break;
            }
        }
        if(res[1] == -1){
            res[1] = j - 1;
        }
        return res;
    }
}