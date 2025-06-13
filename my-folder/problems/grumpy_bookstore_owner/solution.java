class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalCustomers = 0;
        int totalUnsatisfied = 0;
        for(int i = 0; i < customers.length; i++){
            totalCustomers += customers[i];
            if(grumpy[i] == 1){
                totalUnsatisfied += customers[i];
            }
        }
        int unsatisfied = 0;
        int left = 0;
        int right = 0;
        int maxUnsatisfied = 0;
        for(right = 0; right < customers.length; right++){
            if(grumpy[right] == 1){
                unsatisfied += customers[right];
            }
            if(right - left + 1 == minutes){
                if(maxUnsatisfied < unsatisfied){
                    maxUnsatisfied = unsatisfied;
                }
                if(grumpy[left] == 1){
                    unsatisfied -= customers[left];
                }
                left++;
            }
        }
        return totalCustomers - (totalUnsatisfied - maxUnsatisfied);
    }
}