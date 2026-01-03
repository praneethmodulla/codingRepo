class Solution {
    public int numOfWays(int n) {
        long x = 6;
        long y = 6;
        int mod = (int)(1e9 + 7);
        int result = 0;
        for(int i = 2; i <= n; i++){
            long newx = ((2 * x) + (2 * y)) % mod;
            long newy = ((3 * y) + (2 * x)) % mod;
            x = newx;
            y = newy;
        }
        result = (int)((x + y) % mod);
        return result;
    }
}