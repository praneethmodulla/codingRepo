class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a'] += 1;
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++){
                    if(freq[k] > 0){
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                sum += maxFreq - minFreq;
            }
        }
        return sum;
    }
}