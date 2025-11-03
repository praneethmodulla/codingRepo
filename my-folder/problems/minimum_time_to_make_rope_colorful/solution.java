class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        int lastIdx = 0;
        for(int i = 1; i < neededTime.length; i++){
            if(colors.charAt(lastIdx) == colors.charAt(i)){
                if(neededTime[lastIdx] <= neededTime[i]){
                    minTime += neededTime[lastIdx];
                    lastIdx = i;
                } else {
                    minTime += neededTime[i];
                }
            } else {
                lastIdx = i;
            }
        }
        return minTime;
    }
}