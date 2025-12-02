class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            map.put(points[i][1], map.getOrDefault(points[i][1], 0) + 1);
        }
        int mod = (int)1e9 + 7;
        long ans = 0;
        long sum = 0;
        for(int key : map.keySet()){
            int count = map.get(key);
            long edge = ((long)count * (long)(count - 1))/2;
            ans = (ans + (edge * sum)) % mod;
            sum = (sum + edge) % mod;
        }
        return (int)ans;
    }
}