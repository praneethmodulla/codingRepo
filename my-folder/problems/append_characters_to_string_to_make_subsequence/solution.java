class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        for(i = 0; i < s.length(); i++){
            if(j < t.length() && s.charAt(i) == t.charAt(j)){
                j++;
            }
            if(j == t.length()){
                break;
            }
        }
        return t.length() - j;
    }
}