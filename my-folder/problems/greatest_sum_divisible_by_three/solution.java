class Solution {
    public int maxSumDivThree(int[] nums) {
        int r11 = Integer.MAX_VALUE;
        int r12 = Integer.MAX_VALUE;
        int r21 = Integer.MAX_VALUE;
        int r22 = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(nums[i] % 3 == 1){
                if(nums[i] < r11){
                    r12 = r11;
                    r11 = nums[i];
                } else if(nums[i] < r12){
                    r12 = nums[i];
                }
            } else if(nums[i] % 3 == 2){
                if(nums[i] < r21){
                    r22 = r21;
                    r21 = nums[i];
                } else if(nums[i] < r22){
                    r22 = nums[i];
                }
            }
        }
        if(sum % 3 == 1){
            int op1 = r11 != Integer.MAX_VALUE ? r11 : Integer.MAX_VALUE;
            int op2 = r21 != Integer.MAX_VALUE && r22 != Integer.MAX_VALUE ? r21 + r22 : Integer.MAX_VALUE;
            return sum - Math.min(op1, op2);
        }
        if(sum % 3 == 2){
            int op1 = r21 != Integer.MAX_VALUE ? r21 : Integer.MAX_VALUE;
            int op2 = r11 != Integer.MAX_VALUE && r12 != Integer.MAX_VALUE ? r11 + r12 : Integer.MAX_VALUE;
            return sum - Math.min(op1, op2);
        }
        return sum;
    }
}