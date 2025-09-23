class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxfreq = 0;
        for(int num : map.keySet()){
            maxfreq = Math.max(maxfreq, map.get(num)); 
        }
        int total = 0;
        for(int num : map.keySet()){
            if(maxfreq == map.get(num)){
                total += maxfreq;
            }
        }
        return total;
    }
}