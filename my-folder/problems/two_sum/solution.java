class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                result[0] = mp.get(target - nums[i]);
                result[1] = i;
                break;
            }
            mp.put(nums[i], i);
        }
        return result;
    }
}