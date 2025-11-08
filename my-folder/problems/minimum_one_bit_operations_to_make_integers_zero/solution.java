class Solution {
    public int minimumOneBitOperations(int n) {
        int start = 0;
        while(n > 0){
            start = start ^ n;
            n = n >> 1;
        }
        return start;
    }
}



