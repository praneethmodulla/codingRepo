class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total_Pts = 0;
        for(int i = 0; i < cardPoints.length; i++){
            total_Pts += cardPoints[i];
        }
        if(k == cardPoints.length){
            return total_Pts;
        }
        int leftPtr = 0;
        int sum = 0;
        int ans = 0;
        for(int rightPtr = 0; rightPtr < cardPoints.length; rightPtr++){
            sum += cardPoints[rightPtr];
            if(rightPtr - leftPtr + 1 > cardPoints.length - k){
                sum -= cardPoints[leftPtr];
                leftPtr++;
            }
            if(rightPtr - leftPtr + 1 == cardPoints.length - k){
                ans = Math.max(ans, total_Pts - sum);
            }
        }
        return ans;
    }
}