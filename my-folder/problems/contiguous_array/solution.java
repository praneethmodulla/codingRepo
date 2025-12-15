class Solution {
    public int findMaxLength(int[] nums) {
        int countZero = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countZero++;
            } else {
                countZero--;
            }
            if(map.containsKey(countZero)){
                maxLen = Math.max(maxLen, i - map.get(countZero));
            } else {
                map.put(countZero, i);
            }
        }
        return maxLen;
    }
}