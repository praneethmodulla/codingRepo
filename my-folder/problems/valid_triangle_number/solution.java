class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++){
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }
    
    public int binarySearch(int[] nums, int l, int r, int sum){
        int mid = 0;
        while(l <= r){
            mid = (l + r)/2;
            if(nums[mid] >= sum){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}