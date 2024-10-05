class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int minSum = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j= i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - sum) < diff){
                        diff = Math.abs(target - sum);
                        minSum = sum;
                    }
                }
            }
        }
        return minSum;
    }
}