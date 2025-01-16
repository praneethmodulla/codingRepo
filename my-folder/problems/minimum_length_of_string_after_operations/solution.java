class Solution {
    public int minimumLength(String s) {
        if(s.length() <= 2){
            return s.length();
        }
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        int minLength = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                if(freq[i] % 2 == 1){
                    minLength += 1;
                } else {
                    minLength += 2;
                }
            }
        }
        return minLength;
    }
}