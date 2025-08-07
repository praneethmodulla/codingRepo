class Solution {
    int prefixSum;
    int[] prefixArray;
    public Solution(int[] w) {
        this.prefixSum = 0;
        this.prefixArray = new int[w.length];
        for(int i = 0; i < w.length; i++){
            this.prefixSum += w[i];
            prefixArray[i] = prefixSum;
        }
    }
    
    public int pickIndex() {
        double target = Math.random() * this.prefixSum;
        int low = 0;
        int high = prefixArray.length - 1;
        while(low < high){
            int mid =  low + (high - low)/2;
            if(target > prefixArray[mid]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */