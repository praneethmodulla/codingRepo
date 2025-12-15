class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < nums.length; i++){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(hMap.get(nums[i]), maxFreq);
        }
        int ans = nums.length;
        for(int key : hMap.keySet()){
            if(hMap.get(key) == maxFreq){
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
            }
        }
        return ans;
    }
}