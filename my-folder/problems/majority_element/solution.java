class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority_element = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count++;
                majority_element = nums[i];
            } else if(majority_element == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return majority_element;
    }
}