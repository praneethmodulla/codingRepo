class Solution {
    public long maxProduct(int[] nums) {
        long ans = 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < nums.length; i++){
            if(max1 < Math.abs(nums[i])){
                max2 = max1;
                idx2 = idx1;
                max1 = Math.abs(nums[i]);
                idx1 = i;
            } else if(max2 < Math.abs(nums[i])){
                max2 = Math.abs(nums[i]);
                idx2 = i;
            }
        }
        if(idx1 == -1 || idx2 == -1){
            return 0;
        }
        ans = (long)nums[idx1] * (long)nums[idx2];
        if(ans < 0){
            ans = ans * (long)Math.pow(10, 5) * -1;
        } else {
            ans = ans * (long)Math.pow(10, 5);
        }
        return ans;
    }
}