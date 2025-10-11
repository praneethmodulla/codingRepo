class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 0; i < power.length; i++){
            map.put(power[i], map.getOrDefault(power[i], 0) + 1);
        }
        List<int[]> vector = new ArrayList<int[]>();
        for(Integer i : map.keySet()){
            vector.add(new int[]{i, map.get(i)});
        }
        long[] dp = new long[vector.size()];
        long maxPower = 0;
        long mx = 0;
        int j = 0;
        for(int i = 0; i < vector.size(); i++){
            while(j < i && vector.get(j)[0] < vector.get(i)[0] - 2){
                mx = Math.max(mx, dp[j]);
                j++;
            }
            dp[i] = mx + 1L * vector.get(i)[0] * vector.get(i)[1];
            maxPower = Math.max(dp[i], maxPower);
        }
        return maxPower;
    }
}