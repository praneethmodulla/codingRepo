class Solution {
    public boolean canCross(int[] stones) {
        int[][] dp = new int[stones.length][stones.length + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], i);
        }
        recurse(stones, map, 0, -1, dp, 0);
        if(dp[0][0] == 1){
            return true;
        }
        return false;
    }

    public int recurse(int[] stones, HashMap<Integer, Integer> map, int idx, int prevIdx, int[][] dp, int jumpVal){
        if(idx == stones.length - 1){
            return dp[idx][prevIdx + 1] = 1;
        }
        if(dp[idx][prevIdx + 1] != -1){
            return dp[idx][prevIdx + 1];
        }
        if(prevIdx == -1){
            if(map.containsKey(stones[idx] + 1)){
                return dp[idx][prevIdx + 1] = recurse(stones, map, map.get(1), idx, dp, 1);
            }
            return dp[idx][prevIdx + 1] = 0;
        } else {
            int val1 = 0;
            int val2 = 0;
            int val3 = 0;
            if(jumpVal - 1 != 0 && map.containsKey(stones[idx] + jumpVal - 1)){
                val1 = recurse(stones, map, map.get(stones[idx] + jumpVal - 1), idx, dp, jumpVal - 1);
            }
            if(jumpVal != 0 && map.containsKey(stones[idx] + jumpVal)){
                val2 = recurse(stones, map, map.get(stones[idx] + jumpVal), idx, dp, jumpVal);
            }
            if(map.containsKey(stones[idx] + jumpVal + 1)){
                val3 = recurse(stones, map, map.get(stones[idx] + jumpVal + 1), idx, dp, jumpVal + 1);
            }
            return dp[idx][prevIdx + 1] = Math.max(val1, Math.max(val2, val3));
        }
    }
}