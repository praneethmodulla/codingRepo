class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int len = 1;
        int count = 1;
        for(Integer i : set){
            if(!set.contains(i - 1)){
                int num = i;
                len = 1;
                while(set.contains(num + 1)){
                    len += 1;
                    num = num + 1;
                }
                count = Math.max(count, len);
            }
        }
        return count;
    }
}