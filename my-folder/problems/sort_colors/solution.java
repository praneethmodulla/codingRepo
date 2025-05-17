class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
        }
        int j = 0;
        for(int i = 0; i < 3; i++){
            int k = hMap.getOrDefault(i, 0);
            while(k > 0){
                nums[j] = i;
                j++;
                k--;
            }
        }
        return;
    }
}