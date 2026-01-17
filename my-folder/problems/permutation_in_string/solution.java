class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s2.length() - s1.length(); i++){
            if(matches(s1Arr, s2Arr)){
                return true;
            }
            s2Arr[s2.charAt(i + s1.length()) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']--;
        }
        return matches(s1Arr, s2Arr);
    }

    public boolean matches(int[] s1, int[] s2){
        for(int i = 0; i < 26; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
}