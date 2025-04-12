class Solution {
    public int jump(int[] nums) {
        int jumps = 0; 
        int l = 0;
        int r = 0;
        int farthest = 0;
        while(r < nums.length - 1){
            for(int i = l; i <= r; i++){
                farthest = Math.max(nums[i] + i, farthest);
            }
            l = r + 1;
            r = farthest;
            jumps = jumps + 1;
        }
        return jumps;
    }
}