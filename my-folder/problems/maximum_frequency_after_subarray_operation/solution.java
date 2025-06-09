class Solution {
    public int maxFrequency(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for(int i : map.keySet()){
            ans = Math.max(ans, countMax(nums, k, i));
        }
        return ans + map.getOrDefault(k ,0);
    }

    public int countMax(int[] nums, int k, int val){
        int result = 0;
        int current = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                current++;
            }  
            if(nums[i] == k){
                current--;
            }
            if(current < 0){
                current = 0;
            }
            result = Math.max(result, current);
        }
        return result;
    }
}