class Solution {
    public int bestClosingTime(String customers) {
        int totalNumY = 0;
        int totalNumN = 0;
        for(int i = 0; i < customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                totalNumY++;
            }
        }
        int numN = 0;
        int numY = 0;
        int minHour = 0;
        int minPenalty = totalNumY;
        for(int i = 0; i < customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                numY++;
            }
            if(customers.charAt(i) == 'N'){
                numN++;
            }
            int penalty = totalNumY - numY + numN;
            if(minPenalty > penalty){
                minPenalty = penalty;
                minHour = i + 1; 
            }
        }
        return minHour;
    }
}