class Solution {
    public long countDistinct(long n) {
        long answer = 0;
        long x = n;
        int digits = 0;
        while(x != 0){
            x = x/10;
            digits++;
        }
        for(int i = 1; i < digits; i++){
            answer += (long)(Math.pow(9, i));
        }
        String s = Long.toString(n);
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            int digit = c - '0';
            if(digit == 0){
                break;
            }
            answer += (digit - 1) * (long)(Math.pow(9, s.length() - i - 1));
            i++;
        }
        return answer + (i == s.length() ? 1 : 0);
    }
}