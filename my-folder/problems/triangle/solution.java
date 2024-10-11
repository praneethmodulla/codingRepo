class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() - 1;
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        } 
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < dp[n].length; i++){
            if(i == 0){
                dp[n][i] = triangle.get(n).get(i) + recurse(triangle, n - 1, 0, dp);
            } else if(i < dp[n].length - 1){
                dp[n][i] = triangle.get(n).get(i) + Math.min(recurse(triangle, n - 1, i - 1, dp), recurse(triangle, n - 1, i, dp));
            } else {
                dp[n][i] = triangle.get(n).get(i) + recurse(triangle, n - 1, i - 1, dp);
            }
            minVal = Math.min(minVal, dp[n][i]);
        }
        return minVal;
    }

    public int recurse(List<List<Integer>> triangle, int rowIdx, int idx, int[][] dp){
        if(rowIdx < 0){
            return 0;
        }

        if(dp[rowIdx][idx] != -1){
            return dp[rowIdx][idx];
        }
        if(idx == 0){
            dp[rowIdx][idx] = triangle.get(rowIdx).get(idx) + recurse(triangle, rowIdx - 1, 0, dp);
        } else if(idx == triangle.get(rowIdx).size() - 1){
            dp[rowIdx][idx] = triangle.get(rowIdx).get(idx) + recurse(triangle, rowIdx - 1, idx - 1, dp);
        } else {
            dp[rowIdx][idx] = triangle.get(rowIdx).get(idx) + Math.min(recurse(triangle, rowIdx - 1, idx - 1, dp), recurse(triangle, rowIdx - 1, idx, dp));
        }
        return dp[rowIdx][idx];
    }
}