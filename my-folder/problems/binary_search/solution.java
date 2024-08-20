class Solution {
    public int search(int[] nums, int target) {
        return recurse(nums, target, 0, nums.length - 1);
    }
    public int recurse(int[] nums, int target, int low, int high){
        if(low > high) return -1;

        int mid = (low + high)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return recurse(nums, target, low, mid - 1);
        return recurse(nums, target, mid + 1, high);
    }
}