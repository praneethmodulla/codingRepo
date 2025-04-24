class Solution {
    public int candy(int[] ratings) {
        int[] numCandies = new int[ratings.length];
        if(ratings.length == 1){
            return 1;
        }
        Arrays.fill(numCandies, 1);
        for(int i = 0; i < ratings.length; i++){
            if(i == 0){
                if(ratings[i] > ratings[i + 1]){
                    numCandies[i] = numCandies[i + 1] + 1;
                }
            } else if(i == ratings.length - 1){
                if(ratings[i] > ratings[i - 1]){
                    numCandies[i] = numCandies[i - 1] + 1;
                }
            } else {
                if(ratings[i] > ratings[i + 1] && ratings[i] > ratings[i - 1]){
                    numCandies[i] = Math.max(numCandies[i + 1], numCandies[i - 1]) + 1;
                } else if(ratings[i] > ratings[i + 1] && ratings[i] <= ratings[i - 1]){
                    numCandies[i] = numCandies[i + 1] + 1;
                } else if(ratings[i] > ratings[i - 1] && ratings[i] <= ratings[i + 1]){
                    numCandies[i] = numCandies[i - 1] + 1;
                }
            }
        } 
        for(int i = ratings.length - 2; i >=0; i--){
            if(ratings[i] > ratings[i + 1] && numCandies[i] <= numCandies[i + 1]){
                numCandies[i] = numCandies[i + 1] + 1;
            }
        }
        int minCandies = 0;
        for(int i = 0; i < numCandies.length; i++){
            minCandies += numCandies[i];
        }
        return minCandies;
    }
}