class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                left[0] = 1;
                continue;
            }
            left[i] = nums[i - 1] * left[i - 1];
        }
        int[] res = new int[nums.length];
        int R = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = left[i] * R;
            R = R * nums[i];
        }
        return res;
    }
}