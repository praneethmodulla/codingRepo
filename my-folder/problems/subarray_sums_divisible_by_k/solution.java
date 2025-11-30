class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mod = new int[k];
        int result = 0;
        int modSum = 0;
        mod[0] = 1;
        for(int i = 0; i < nums.length; i++){
            modSum = (modSum + nums[i]%k + k) % k;
            result += mod[modSum];
            mod[modSum]++;  
        }
        return result;
    }
}