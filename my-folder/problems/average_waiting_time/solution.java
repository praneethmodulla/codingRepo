class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitTime = 0;
        int num = customers.length;
        double chefTime = 0;
        for(int i = 0; i < customers.length; i++){
            if(chefTime < customers[i][0]){
                chefTime = customers[i][0];
                chefTime += customers[i][1];
                waitTime += chefTime - customers[i][0];
            } else {
                chefTime += customers[i][1];
                waitTime += chefTime - customers[i][0];
            }
        }
        return waitTime/num;
    }
}