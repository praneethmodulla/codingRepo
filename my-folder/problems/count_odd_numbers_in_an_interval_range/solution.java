class Solution {
    public int countOdds(int low, int high) {
        int ans = 0;
        int num = high - low;
        ans += num / 2;
        if(num % 2 == 1){
            if(high % 2 == 1){
                ans++;
            }
        }
        if(low % 2 == 1){
            ans++;
        }
        return ans;
    }
}