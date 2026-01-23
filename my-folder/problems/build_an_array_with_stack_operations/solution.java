class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<String>();
        int k = 0;
        for(int i = 1; i <= n; i++){
            result.add("Push");
            if(target[k] == i){
                k++;
                if(k == target.length){
                    break;
                }
                continue;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}