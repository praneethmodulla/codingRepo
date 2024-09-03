class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        res = recurse(candidates, target, set, res, 0);
        return res;
    }

    public List<List<Integer>> recurse(int[] nums, int target, List<Integer> set, List<List<Integer>> res, int idx){
        if(target < 0){
            return res;
        }
        if(idx == nums.length){
            if(target == 0){
                List<Integer> copySet = new ArrayList<Integer>();
                for(int i = 0; i < set.size(); i++){
                    copySet.add(set.get(i));
                }
                res.add(copySet);
                return res;
            } else {
                return res;
            }
        }
        set.add(nums[idx]);
        res = recurse(nums, target - nums[idx], set, res, idx);
        set.remove(set.size() - 1);
        res = recurse(nums, target, set, res, idx + 1);
        return res;
    }
}