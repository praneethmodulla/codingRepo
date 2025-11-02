class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int power = 31;
        while(power > 0){
            int lsb = n & 1;
            ans = ans | lsb;
            ans = ans << 1;
            n = n >> 1;
            power--;
        }
        return ans;
    }
}