class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        int len = 0;
        for(int i : set){
            len = 0;
            if(!set.contains(i - 1)){
                int num = i;
                len = 1;
                while(set.contains(num + 1)){
                    num = num + 1;
                    len = len + 1;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}