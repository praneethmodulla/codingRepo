class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        int ans = 0;
        for(char ch : set){
            int i = -1;
            int j = 0;
            for(int k = 0; k < s.length(); k++){
                if(ch == s.charAt(k)){
                    if(i == -1){
                        i = k;
                    }
                    j = k;
                }
            }
            HashSet<Character> between = new HashSet<Character>();
            for(int g = i + 1; g < j; g++){
                between.add(s.charAt(g));
            }
            ans += between.size();
        }
        return ans;
    }
}