class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        double prefix = 1;
        double suffix = 1;
        double max = Double.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(prefix == 0){
                prefix = 1;
            } 
            if(suffix == 0){
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return (int)max;
    }
}