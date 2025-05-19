class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int cnt = 0;
        int high = nums.length - 1;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int sum = nums[i] + nums[j];
                int k = j + 1;
                high = bSearch(nums, sum, k, target, Math.min(high, nums.length - 1));
                cnt = cnt + high - k;
            }
        }
        return cnt;
    }
    public int bSearch(int[] nums, int sum, int k, int target, int limit){
        int low = k;
        int high = limit;
        while(low <= high){
            int mid = (low + high)/2;
            if(sum + nums[mid] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}