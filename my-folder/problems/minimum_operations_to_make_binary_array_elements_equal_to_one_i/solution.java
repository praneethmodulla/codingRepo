class Solution {
    public int minOperations(int[] nums) {
        int minOps = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(i < nums.length - 2){
                    nums[i] = 1;
                    if(nums[i + 1] == 0){
                        nums[i + 1] = 1;
                    } else {
                        nums[i + 1] = 0;
                    }
                    if(nums[i + 2] == 0){
                        nums[i + 2] = 1;
                    } else {
                        nums[i + 2] = 0;
                    }
                    minOps++;
                }

            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                return -1;
            }
        }
        return minOps;   
    }
}