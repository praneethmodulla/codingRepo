class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[nums.length - 1] != nums[nums.length - 2]){
            return nums[nums.length - 1];
        }

        int low = 1;
        int high = nums.length - 2;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            if(nums[mid] == nums[mid - 1]){
                if(mid % 2 == 0){
                    high = mid - 1;
                } else {
                    low = mid  + 1;
                }
            } else if(nums[mid] == nums[mid + 1]){
                if(mid % 2 == 0){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                } 
            }
        }
        return nums[mid];
    }
}