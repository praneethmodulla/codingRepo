class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        recurse(candidates, target, res, result, 0);
        return result;
    }

    public void recurse(int[] nums, int target, List<Integer> res, List<List<Integer>> result, int idx){
        if(target < 0){
            return;
        }
        if(idx == nums.length){
            if(target == 0){
                result.add(new ArrayList<Integer>(res));
            }
            return;
        }
        res.add(nums[idx]);
        recurse(nums, target - nums[idx], res, result, idx);
        res.remove(res.size() - 1);
        recurse(nums, target, res, result, idx + 1);
        return;
    }
}