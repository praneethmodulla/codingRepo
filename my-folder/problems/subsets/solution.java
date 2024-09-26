class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result = recurse(nums, set, result, 0);
        return result;
    }

    public List<List<Integer>> recurse(int[] nums, List<Integer> set, List<List<Integer>> result, int idx){
        if(idx == nums.length){
            List<Integer> copySet = new ArrayList<>(set);
            result.add(copySet);
            return result;
        }
        set.add(nums[idx]);
        result = recurse(nums, set, result, idx + 1);
        set.remove(set.size() - 1);
        result = recurse(nums, set, result, idx + 1);
        return result;
    }
}