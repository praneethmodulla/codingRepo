class Solution {
    public boolean makePalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int num = 0;
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                continue;
            }
            num++;
            if(num > 2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}