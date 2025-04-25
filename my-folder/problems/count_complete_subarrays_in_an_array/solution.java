class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int distinct = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                distinct++;
                set.add(nums[i]);
            }
        }
        return helper(nums, distinct) - helper(nums, distinct - 1);
    }

    public int helper(int[] nums, int distinct){
        int left = 0;
        int right = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > distinct){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}