class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result = recurse(n, k, result, set);
        return result;
    }

    public List<List<Integer>> recurse(int n, int k, List<List<Integer>> result, List<Integer> set){
        if(set.size() == k){
            List<Integer> copySet = new ArrayList<Integer>(set);
            result.add(copySet);
            return result;
        }
        if(n == 0){
            return result;
        }
        set.add(n);
        result = recurse(n - 1, k, result, set);
        set.remove(set.size() - 1);
        result = recurse(n - 1, k, result, set);
        return result;
    }
}