class Solution {
    public int countSubstrings(String s) {
        int i = 0;
        int count = 0;
        while(i < s.length()){
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    count += 1;
                } else {
                    break;
                }
                left--;
                right++;
            }
            i++;
        }
        i = 0;
        while(i < s.length() - 1){
            int left = i;
            int right = i + 1;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    count += 1;
                } else {
                    break;
                }
                left--;
                right++;
            }
            i++;
        }
        return count;
    }
}