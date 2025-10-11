class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> vector = new ArrayList<int[]>();
        for(int i : map.keySet()){
            vector.add(new int[]{i, map.get(i)});
        }
        int[] dp = new int[vector.size()];
        int j = 0;
        int max = 0;
        int mx = 0;
        for(int i = 0; i < vector.size(); i++){
            while(j < i && vector.get(j)[0] < vector.get(i)[0] - 1){
                mx = Math.max(mx, dp[j]);
                j++;
            } 
            dp[i] = mx + vector.get(i)[0] * vector.get(i)[1];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}