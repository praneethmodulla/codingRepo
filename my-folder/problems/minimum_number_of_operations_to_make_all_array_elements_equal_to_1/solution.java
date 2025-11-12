class Solution {
    public int minOperations(int[] nums) {
        int num1 = 0;
        int g = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                num1++;
            }
            g = gcd(g, nums[i]);
        }
        if(num1 > 0){
            return nums.length - num1;
        }
        if(g > 1){
            return -1;
        }
        int minLen = nums.length;
        for(int i = 0; i < nums.length; i++){
            int currentGcd = 0;
            for(int j = i; j < nums.length; j++){
                currentGcd = gcd(currentGcd, nums[j]);
                if(currentGcd == 1){
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + nums.length - 2;
    }

    public int gcd(int a, int b){
        if(b > a){
            return gcd(b, a);
        }
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}