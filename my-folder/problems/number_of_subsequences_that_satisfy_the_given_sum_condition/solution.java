class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int mod = 1_000_000_007;
        int[] power = new int[nums.length];
        power[0] = 1;
        for(int k = 1; k < nums.length; k++){
            power[k] = (power[k - 1] * 2) % mod;
        }
        int ans = 0;
        while(i <= j){
            if(nums[i] + nums[j] <= target){
                ans += power[j - i];
                ans %= mod;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}