class Solution {
    public int monkeyMove(int n) {
        return (int)(1000000007 + power(n) - 2)%1000000007;
    }
    public long power(int n){
        int mod = 1000000007;
        if(n == 1){
            return 2;
        }
        if(n%2 == 0){
            long half = power(n/2);
            return (half*half)%mod;
        }
        long half = power(n/2);
        return ((half*half)%mod)*2%mod; 
    }
}