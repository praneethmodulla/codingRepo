class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int i = 1; 
        int prevSmall = -1;
        int prevGreat = -1;
        while(i < nums.length - 1){
            if(nums[i] > nums[i - 1]){
                prevSmall = nums[i - 1];
            } else if(nums[i] < nums[i - 1]){
                prevGreat = nums[i - 1];
            }
            while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
            if(i < nums.length - 1 && prevGreat != -1 && nums[i + 1] > nums[i] && prevGreat > nums[i]){
                count++;
            } else if(i < nums.length - 1 && prevSmall != -1 && nums[i + 1] < nums[i] && prevSmall < nums[i]){
                count++;
            }
            i++;
            prevGreat = -1;
            prevSmall = -1;
        }
        return count;
    }
}