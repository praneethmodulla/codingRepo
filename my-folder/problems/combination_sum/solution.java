class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum = 0;
        List<Integer> set = new ArrayList<Integer>();
        result = recurse(result, set, sum, 0, candidates, target);
        return result;
    }

    public List<List<Integer>> recurse(List<List<Integer>> result, List<Integer> set, int sum, int idx, int[] nums, int target){
        if(sum > target){
            return result;
        }
        if(sum == target){
            List<Integer> copySet = new ArrayList<Integer>(set);
            result.add(copySet);
            return result;
        }
        if(idx == nums.length){
            return result;
        }
        sum += nums[idx];
        set.add(nums[idx]);
        result = recurse(result, set, sum, idx, nums, target);
        sum -= nums[idx];
        set.remove(set.size() - 1);
        result = recurse(result, set, sum, idx + 1, nums, target);
        return result;
    }
}