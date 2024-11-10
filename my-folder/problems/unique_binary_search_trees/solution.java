class Solution {
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }   
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int numLeftNodes = i - 1;
            int numRightNodes = n - i;
            if(numLeftNodes <= 1){
                ans += numTrees(numRightNodes);
            } else if(numRightNodes <= 1){
                ans += numTrees(numLeftNodes);
            } else {
                ans += numTrees(numLeftNodes) * numTrees(numRightNodes);
            }
        }
        return ans;
    }
}