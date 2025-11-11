class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        HashMap<Integer, Integer> countOne = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> countZero = new HashMap<Integer, Integer>();
        for(int i = 0; i < strs.length; i++){
            int numOne = 0;
            int numZero = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '1'){
                    numOne++;
                } else {
                    numZero++;
                }
            }
            countOne.put(i, numOne);
            countZero.put(i, numZero);
        }
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for(int[][] mat : dp){
            for(int[] row: mat){
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return recurse(countOne, countZero, m, n, strs.length - 1, strs, dp);
    }

    public int recurse(HashMap<Integer, Integer> countOne, HashMap<Integer, Integer> countZero, int m, int n, int idx, String[] strs, int[][][] dp){
        if(m == 0 && n == 0 && idx >= 0){
            return dp[idx][m][n] = 0;
        }
        if(m < 0 || n < 0){
            return Integer.MIN_VALUE;
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx][m][n] != Integer.MIN_VALUE){
            return dp[idx][m][n];
        }
        int numZero = countZero.get(idx);
        int numOne = countOne.get(idx);
        int take = -1;
        if(m - numZero >= 0 && n - numOne >= 0){
            take = 1 + recurse(countOne, countZero, m - numZero, n - numOne, idx - 1, strs, dp);
        }
        int notTake = recurse(countOne, countZero, m, n, idx - 1, strs, dp);
        return dp[idx][m][n] = Math.max(take, notTake);
    }
}