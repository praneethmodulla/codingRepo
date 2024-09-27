class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        int sum = 0;
        result = recurse(result, set, candidates, target, sum, 0);
        return result;
    }

    public List<List<Integer>> recurse(List<List<Integer>> result, List<Integer> set, int[] candidates, int target, int sum, int idx){
        if(idx == candidates.length){
            if(sum == target){
                List<Integer> copySet = new ArrayList<Integer>(set);
                result.add(copySet);
            }
            return result;
        }
        if(sum > target){
            return result;
        }
        if(sum == target){
            List<Integer> copySet = new ArrayList<Integer>(set);
            result.add(copySet);
            return result;
        }
        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i - 1]){
                continue;
            }
            sum += candidates[i];
            set.add(candidates[i]);
            result = recurse(result, set, candidates, target, sum, i + 1);
            sum -= candidates[i];
            set.remove(set.size() - 1);
        }
        return result;
    }
}