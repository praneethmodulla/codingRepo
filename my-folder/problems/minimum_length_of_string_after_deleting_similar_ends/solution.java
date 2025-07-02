class Solution {
    public int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return j - i + 1;
            } else {
                char sc = s.charAt(i);
                char ec = s.charAt(j);
                while(i < s.length() && s.charAt(i) == ec){
                    i++;
                }
                while(j >= 0 && s.charAt(j) == sc){
                    j--;
                }
            }
        }
        if(i > j){
            return 0;
        }
        return j - i + 1;
    }
}