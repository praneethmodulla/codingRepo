class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        recurse(nums, 0, res, result);
        return result;
    }

    public void recurse(int[] nums, int idx, List<Integer> res, List<List<Integer>> result){
        if(idx == nums.length){
            result.add(new ArrayList<Integer>(res));
            return;
        }

        res.add(nums[idx]);
        recurse(nums, idx + 1, res, result);
        res.remove(res.size() - 1);
        recurse(nums, idx + 1, res, result);
        return;
    }
}