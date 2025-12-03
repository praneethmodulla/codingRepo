class Solution {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(target.startsWith(nums[i])){
                if(map.containsKey(target.substring(nums[i].length(), target.length()))){
                    cnt += map.get(target.substring(nums[i].length(), target.length()));
                }
            }
            if(target.endsWith(nums[i])){
                if(map.containsKey(target.substring(0, target.length() - nums[i].length()))){
                    cnt += map.get(target.substring(0, target.length() - nums[i].length()));
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return cnt;
    }
}