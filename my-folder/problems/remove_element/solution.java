class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(i < nums.length){
            if(i == j && nums[i] != val){
                i++;
                j++;
            } else if(i == j && nums[i] == val){
                i++;
            } else if(i != j && nums[i] != val){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            } else {
                i++;
            }
        }
        return j;
    }
}