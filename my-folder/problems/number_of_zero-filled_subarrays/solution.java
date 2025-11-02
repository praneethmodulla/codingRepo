class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int start = -1;
        int end = -1;
        long count = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                start = i;
                while(i < nums.length && nums[i] == 0){
                    i++;
                }
                long num = i - start;
                count += (num) * (num + 1)/2;
            }
            i++;
        }
        return count;
    }
}