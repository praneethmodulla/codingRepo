class Solution {
    public int distributeCandies(int n, int limit) {
        int count = 0;
        for(int j = 0; j <= limit; j++){
            for(int k = 0; k <= limit; k++){
                if(n - (j + k) <= limit && n - (j + k) >= 0){
                    count++;
                }
            }
        }
        return count;
    }
}