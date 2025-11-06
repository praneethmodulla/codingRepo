class Solution {
    public int largestCombination(int[] candidates) {
        int[] count = new int[24];
        for(int i = 0; i < candidates.length; i++){
            int n = candidates[i];
            int j = 0;
            while(n != 0){
                if((n & 1) == 1){
                    count[j]++;
                }
                n = n >> 1;
                j++;
            }
        }
        int max = 0;
        for(int i = 0; i < count.length; i++){
            max = Math.max(max, count[i]);
        }
        return max;
    }
}