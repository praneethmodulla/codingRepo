class Solution {
    public double myPow(double x, int n) {
        if(x == 1){
            return 1;
        } 
        if(n == 0){
            return 1;
        }
        if(x == -1){
            if(n%2 == 0){
                return 1;
            } else {
                return -1;
            }
        }
        double ans = 1;
        long nn = n;
        if(nn < 0){
            nn = -1 * nn;
        }
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1; 
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n < 0){
            return (double)1/(double)ans;
        } else {
            return ans;
        }
    }
}