class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factorList = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                factorList.add(i);
            }
        }
        if(k > factorList.size()){
            return -1; 
        }
        return factorList.get(k - 1);
    }
}