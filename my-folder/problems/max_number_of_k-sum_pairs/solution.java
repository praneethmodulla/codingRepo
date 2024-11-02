class Solution {
    public int maxOperations(int[] nums, int k) {
        int numOperations = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] == k){
                i++;
                j--;
                numOperations++;
            } else if(nums[i] + nums[j] > k){
                j--;
            } else {
                i++;
            }
        }
        return numOperations;
    }
}