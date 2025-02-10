class Solution {
    public long countBadPairs(int[] nums) {
        long cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int diff = i - nums[i];
            int good = map.getOrDefault(diff, 0);
            cnt += i - good;
            map.put(diff, good + 1);
        }
        return cnt;
    }
}