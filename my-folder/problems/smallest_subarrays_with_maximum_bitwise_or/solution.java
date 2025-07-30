class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] pos = new int[31];
        Arrays.fill(pos, -1);
        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            int j = i;
            for(int k = 0; k < 31; k++){
                if((nums[i] & (1 << k)) == 0){
                    if(pos[k] != -1){
                        j = Math.max(j, pos[k]);
                    }
                } else {
                    pos[k] = i;
                }
            }
            ans[i] = j - i + 1;
        }
        return ans;
    }
}