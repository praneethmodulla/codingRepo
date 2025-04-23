class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        recurse(candidates, target, 0, result, res);
        return result;
    }

    public void recurse(int[] nums, int target, int idx, List<List<Integer>> result, List<Integer> res){
        if(idx == nums.length){
            if(target == 0){
                result.add(new ArrayList<Integer>(res));
            }
            return;
        }
        if(target < 0){
            return;
        }
        res.add(nums[idx]);
        recurse(nums, target - nums[idx], idx + 1, result, res);
        res.remove(res.size() - 1);
        int j = idx;
        while(j < nums.length && nums[j] == nums[idx]){
            j++;
        }
        idx = j;
        recurse(nums, target, idx, result, res);
        return;
    }
}