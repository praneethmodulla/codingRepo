class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result = recurse(result, set, k, n, 1, 0);
        return result;
    }

    public List<List<Integer>> recurse(List<List<Integer>> result, List<Integer> set, int length, int targetSum, int val, int sum){
        if(set.size() == length){
            if(sum == targetSum){
                result.add(new ArrayList<Integer>(set));
            }
            return result;
        }
        if(val > 9){
            return result;
        }
        set.add(val);
        sum += val;
        result = recurse(result, set, length, targetSum, val + 1, sum);
        set.remove(set.size() - 1);
        sum -= val;
        result = recurse(result, set, length, targetSum, val + 1, sum);

        return result;
    }
}