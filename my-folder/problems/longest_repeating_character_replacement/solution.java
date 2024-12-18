class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int leftPtr = 0;
        int rightPtr = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(rightPtr = 0; rightPtr < s.length(); rightPtr++){
            hash[s.charAt(rightPtr) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(rightPtr) - 'A']);
            if((rightPtr - leftPtr + 1) - maxFreq > k){
                hash[s.charAt(leftPtr) - 'A']--;
                leftPtr = leftPtr + 1; 
            }
            if((rightPtr - leftPtr + 1) - maxFreq <= k){
                maxLen = Math.max(maxLen, rightPtr - leftPtr + 1);
            } 
        }
        return maxLen;
    }
}