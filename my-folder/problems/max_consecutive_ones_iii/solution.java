class Solution {
    public int longestOnes(int[] nums, int k) {
        int leftPointer = 0;
        int rightPointer = 0;
        int len = 0;
        int counter = 0;
        for(rightPointer = 0; rightPointer < nums.length; rightPointer++){
            if(nums[rightPointer] != 1 && counter == k){
                if(len < rightPointer - leftPointer){
                    len = rightPointer - leftPointer;
                }
                while(counter >= k){
                    if(nums[leftPointer] == 0){
                        counter--;
                    }
                    leftPointer++;
                }
            }
            if(nums[rightPointer] != 1 && counter < k){
                counter++;
            }
        }
        if(len < rightPointer - leftPointer){
            len = rightPointer - leftPointer;
        }
        return len;
    }
}