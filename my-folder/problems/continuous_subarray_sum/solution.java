class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, -1);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
        for(int i = 0; i < nums.length; i++){
            prefixSum[i] = prefixSum[i]%k;
            if(mp.containsKey(prefixSum[i])){
                if(mp.get(prefixSum[i]) < i - 1){
                    return true;
                }
            } else {
                mp.put(prefixSum[i], i);
            }
        }
        return false;
    }
}