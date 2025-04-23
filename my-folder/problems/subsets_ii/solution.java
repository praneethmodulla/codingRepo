class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums);
        recurse(nums, 0, result, res);
        return result;
    }

    public void recurse(int[] nums, int idx, List<List<Integer>> result, List<Integer> res){
        if(idx == nums.length){
            result.add(new ArrayList<Integer>(res));
            return;
        }
        res.add(nums[idx]);
        recurse(nums, idx + 1, result, res);
        res.remove(res.size() - 1);
        int j = idx;
        while(j < nums.length && nums[j] == nums[idx]){
            j++;
        }
        idx = j;
        recurse(nums, idx, result, res);
        return;
    }
}