class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        recurse(k, n, result, res, 1);
        return result;
    }

    public void recurse(int k, int n, List<List<Integer>> result, List<Integer> res, int num){
        if(k == 0){
            if(n == 0){
                result.add(new ArrayList<Integer>(res));
            }
            return;
        }
        if(num > 9){
            return;
        }
        res.add(num);
        recurse(k - 1, n - num, result, res, num + 1);
        res.remove(res.size() - 1);
        recurse(k, n, result, res, num + 1);
        return;
    }
}