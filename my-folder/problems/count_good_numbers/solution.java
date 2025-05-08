class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        if(n % 2 == 0){
            return (int)((quickMul(5, n/2) * quickMul(4, n/2)) % mod);
        }
        return (int)((quickMul(5, (n/2) + 1) * quickMul(4, n/2)) % mod);
        
    }

    public long quickMul(int x, long y){
        long res = 1;
        long mul = x;
        while(y > 0){
            if(y % 2 == 0){
                mul = (long)((mul * mul) % mod);
                y = y / 2;
            } else {
                res = (long)((res * mul) % mod);
                y = y - 1; 
            }
        }
        return res;
    }
}