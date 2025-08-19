class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int power = 0;
        List<Integer> powers = new ArrayList<Integer>();
        int mod = (int)1e9 + 7;
        while(n > 0){
            if((n & 1) == 1){
                int num = ((int)Math.pow(2, power));
                powers.add(num);
            }
            n = n >> 1;
            power++;
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            long cur = 1;
            for(int k = queries[i][0]; k <= queries[i][1]; k++){
                cur = (cur * powers.get(k))%mod;
            }
            ans[i] = (int)cur;
        }
        return ans;
    }
}