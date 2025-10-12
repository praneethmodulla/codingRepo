class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i = 1; i <= n; i++){
            int prev = res.size();
            int mask = 1 << (i - 1);
            for(int j = prev - 1; j >= 0; j--){
                res.add(mask + res.get(j));
            }
        }
        return res;
    }
}