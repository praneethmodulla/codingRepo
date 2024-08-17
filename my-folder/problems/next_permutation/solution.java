class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            for(int i = 0; i < nums.length/2; i++){
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        } else {
            for(int i = nums.length - 1; i > ind; i--){
                if(nums[i] > nums[ind]){
                    int temp = nums[ind];
                    nums[ind] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            int j = ind + 1;
            int len = nums.length - 1;
            while(j <= len){
                int temp = nums[len];
                nums[len] = nums[j];
                nums[j] = temp;
                j++;
                len--;
            }
        }
    }
}