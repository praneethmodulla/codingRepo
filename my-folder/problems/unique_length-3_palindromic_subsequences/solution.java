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
                if(s.charAt(k) == ch){
                    if(i == -1){
                        i = k;
                    }
                    j = k;
                }
            }

            HashSet<Character> between = new HashSet<Character>();
            for(int m = i + 1; m < j; m++){
                between.add(s.charAt(m));
            }
            ans += between.size();
        }
        return ans;
    }
}