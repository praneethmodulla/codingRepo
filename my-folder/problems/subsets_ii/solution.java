class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result = recurse(result, set, nums, 0);
        return result;
    }

    public List<List<Integer>> recurse(List<List<Integer>> result, List<Integer> set, int[] nums, int idx){
        result.add(new ArrayList<Integer>(set));
        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i - 1]){
                continue;
            }
            set.add(nums[i]);
            result = recurse(result, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
        return result;
    }
}