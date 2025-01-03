class Solution {
    public int reverse(int x) {
        int rev = 0;
        int absVal = Math.abs(x);
        while(absVal != 0){
            int digit = absVal%10;
            if(rev > (Integer.MAX_VALUE - digit)/10){
                return 0;
            }
            rev = (rev * 10) + digit;

            absVal = absVal/10;
        }
        if(x < 0){
            return -1 * rev;
        }
        return rev;
    }
}