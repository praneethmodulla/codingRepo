class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = ans | nums[i];
            if(max < ans){
                max = ans;
            }
        }
        int[] count = new int[1];
        recurse(nums, nums.length - 1, count, max, 0);
        return count[0];
    }

    public void recurse(int[] nums, int idx, int[] count, int max, int val){
        if(idx < 0){
            if(val == max){
                count[0] += 1;
            }
            return;
        }

        recurse(nums, idx - 1, count, max, val);
        recurse(nums, idx - 1, count, max, val | nums[idx]);
        return;
    }
}