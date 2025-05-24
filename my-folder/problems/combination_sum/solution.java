class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       List<Integer> set = new ArrayList<Integer>();
       recurse(candidates, target, 0, 0, set, result);
       return result;
    }

    public void recurse(int[] candidates, int target, int sum, int idx, List<Integer> set, List<List<Integer>> res){
        if(sum > target){
            return;
        }
        if(sum == target){
            List<Integer> arr = new ArrayList<Integer>(set);
            res.add(arr);
            return;
        }
        if(idx == candidates.length){
            return;
        }
        recurse(candidates, target, sum, idx + 1, set, res);
        sum += candidates[idx];
        set.add(candidates[idx]);
        recurse(candidates, target, sum, idx, set, res);
        sum -= candidates[idx];
        set.remove(set.size() - 1);
        return;
    }

    
}