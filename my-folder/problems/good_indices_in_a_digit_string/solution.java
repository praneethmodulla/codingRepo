class Solution {
    public List<Integer> goodIndices(String s) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            String target = String.valueOf(i);
            String check = s.substring(i + 1 - target.length(), i + 1);
            if(check.equals(target)){
                res.add(i);
            }
        }
        return res;
    }
}