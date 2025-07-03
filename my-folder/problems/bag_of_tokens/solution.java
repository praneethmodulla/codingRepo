class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int i = 0;
        int j = tokens.length - 1;
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i];
                score += 1;
                i++;
            } else if(power < tokens[i] && score == 0){
                break;
            } else if(power < tokens[i] && score > 0){
                if(i == j){
                    break;
                }
                power += tokens[j];
                j--;
                score -= 1;
            }
        }
        return score;
    }
}