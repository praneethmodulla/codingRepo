class Solution {
    public int specialTriplets(int[] nums) {
        int mod = (int)1e9 + 7;
        long ans = 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> countPartial = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i < nums.length - 1; i++){
            int req = 2 * nums[i];
            int left = countPartial.getOrDefault(req, 0);
            countPartial.put(nums[i], countPartial.getOrDefault(nums[i], 0) + 1);
            int right = count.getOrDefault(req, 0) - countPartial.getOrDefault(req, 0);
            ans = (ans + (long)left * right) % mod;
        }
        return (int)ans;
    }
}