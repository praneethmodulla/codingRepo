class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long[] prefixSum = new long[shifts.length];
        for(int i = shifts.length - 1; i >= 0; i--){
            if(i == shifts.length - 1){
                prefixSum[i] = shifts[i];
            } else {
                prefixSum[i] = prefixSum[i + 1] + shifts[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            prefixSum[i] = prefixSum[i]%26;
            if(ch + prefixSum[i] > ((int)'z')){
                ch = (char)(ch + prefixSum[i] - ((int)'z') + ((int)'a') - 1);
            } else {
                ch = (char)(ch + prefixSum[i]);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}