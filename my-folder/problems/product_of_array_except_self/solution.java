class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];

        leftProd[0] = 1;
        for(int i = 1; i < nums.length; i++){
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
        }

        rightProd[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            rightProd[i] = rightProd[i + 1] * nums[i + 1]; 
        }

        for(int i = 0; i < res.length; i++){
            res[i] = leftProd[i] * rightProd[i]; 
        } 
        return res;
    }
}