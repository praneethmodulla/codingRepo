class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        hMap.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hMap.containsKey(sum - goal)){
                count += hMap.get(sum - goal);
            }
            hMap.put(sum, hMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}