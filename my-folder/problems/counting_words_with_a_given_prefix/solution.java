class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        int len = pref.length();
        for(int i = 0; i < words.length; i++){
            if(words[i].length() >= len && pref.equals(words[i].substring(0, len))){
                cnt++;
            }
        }
        return cnt;
    }
}