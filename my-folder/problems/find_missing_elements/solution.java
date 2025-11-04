class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == start + 1){
                start = start + 1;
            } else {
                result.add(start + 1);
                start = start + 1;
                i--;
            }
        }
        return result;
    }
}