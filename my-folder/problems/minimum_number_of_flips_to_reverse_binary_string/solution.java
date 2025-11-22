class Solution {
    public int minimumFlips(int n) {
        int rev = 0;
        int original = n;
        while(original != 0){
            int digit = original & 1;
            rev = rev << 1;
            rev = rev | digit;
            original = original >> 1;
        }
        original = n; 
        int reverse = rev;
        int count = 0;
        while(original != 0){
            int or = original & 1;
            int r = reverse & 1;
            if(or != r){
                count++;
            }
            original = original >> 1;
            reverse = reverse >> 1;
        }
        return count;
    }
}