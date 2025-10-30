class Solution {
    public int smallestNumber(int n) {
        if(((n + 1) & n) == 0){
            return n;
        }
        return smallestNumber(n + 1);
    }
}