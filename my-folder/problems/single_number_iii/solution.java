class Solution {
    public int[] singleNumber(int[] nums) {
        int xorr = 0;
        for(int i = 0; i < nums.length; i++){
            xorr = xorr ^ nums[i];
        }
        int rmsb = xorr & (xorr - 1);
        rmsb = rmsb ^ xorr;
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & rmsb) != 0){
                res[0] = res[0] ^ nums[i];
            } else {
                res[1] = res[1] ^ nums[i];
            }
        }
        return res;
    }
}