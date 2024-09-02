class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        res = recurse(nums, set, res, 0);
        return res;
    }
    public List<List<Integer>> recurse(int[] nums, List<Integer> set, List<List<Integer>> res, int idx){
        if(idx == nums.length){
            List<Integer> copySet = new ArrayList<Integer>();
            for(int i = 0; i < set.size(); i++){
                copySet.add(set.get(i));
            }
            res.add(copySet);
            return res;
        }
        set.add(nums[idx]);
        res = recurse(nums, set, res, idx + 1);
        set.remove(set.size() - 1);
        res = recurse(nums, set, res, idx + 1);
        return res;
    }
}