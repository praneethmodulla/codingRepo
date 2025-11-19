class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int num = original;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num){
                num = num * 2;
            }
        }
        return num;
    }
}