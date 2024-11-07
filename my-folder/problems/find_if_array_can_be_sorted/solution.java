class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    if(countBits(nums[j], nums[j + 1])){
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean countBits(int num1, int num2){
        int count1 = 0;
        int count2 = 0;
        while(num1 != 0){
            count1 += num1 & 1;
            num1 >>>= 1;
        }
        while(num2 != 0){
            count2 += num2 & 1;
            num2 >>>= 1;
        }
        if(count1 == count2){
            return true;
        }
        return false;
    }
}