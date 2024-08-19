class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 1; i <= numRows; i++){
            List<Integer> res = new ArrayList<>();
            if(i == 1){
                res.add(1);
                result.add(res);
            } else if(i == 2){
                res.add(1);
                res.add(1);
                result.add(res);
            } else {
                res.add(1);
                List<Integer> prev= result.get(i - 2);
                for(int j = 0; j < prev.size() - 1; j++){
                    res.add(prev.get(j) + prev.get(j + 1));
                }
                res.add(1);
                result.add(res);
            }
        }
        return result;
    }
}