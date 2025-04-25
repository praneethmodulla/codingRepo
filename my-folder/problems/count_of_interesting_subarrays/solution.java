class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long num = 0;
        int cnt = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) % modulo == k){
                cnt += 1;
            }
            if(map.containsKey((cnt - k + modulo)%modulo)){
                num += map.get((cnt - k + modulo)%modulo);
            }
            map.put(cnt % modulo, map.getOrDefault(cnt % modulo, 0) + 1);
        }
        return num;
    }
}