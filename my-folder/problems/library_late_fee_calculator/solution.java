class Solution {
    public int lateFee(int[] daysLate) {
        int total = 0;
        for(int i = 0; i < daysLate.length; i++){
            if(daysLate[i] == 1){
                total += 1;
            } else if(daysLate[i] >= 2 && daysLate[i] <= 5){
                total += 2 * daysLate[i];
            } else {
                total += 3 * daysLate[i];
            }
        }
        return total;
    }
}