class Solution {
    public int maxScore(String s) {
        int maxVal = Integer.MIN_VALUE;
        for(int i = 1; i < s.length(); i++){
            int score = countZeroes(s.substring(0, i)) + countOnes(s.substring(i, s.length()));
            if(maxVal < score){
                maxVal = score;
            }
        }
        return maxVal;
    }

    public int countZeroes(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                cnt++;
            }
        }
        return cnt;
    }

    public int countOnes(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}