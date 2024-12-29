class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long prod = 1;
        int count = 0;
        int rightPtr = 0;
        int leftPtr = 0;
        for(rightPtr = 0; rightPtr < nums.length; rightPtr++){
            prod *= nums[rightPtr];
            while(prod >= k && leftPtr <= rightPtr){
                prod = prod/nums[leftPtr];
                leftPtr++;
            }
            if(prod < k){
                count += rightPtr - leftPtr + 1;
            }
        }
        return count;
    }
}