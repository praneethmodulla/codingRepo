class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid = new int[n][n];
        for(int[] row : grid){
            Arrays.fill(row, 0);
        }
        int[][] diff = new int[n + 1][n + 1];
        for(int i = 0; i < queries.length; i++){
            int row1 = queries[i][0];
            int row2 = queries[i][2];
            int col1 = queries[i][1];
            int col2 = queries[i][3];
            diff[row1][col1] += 1;
            diff[row2 + 1][col1] -= 1;
            diff[row1][col2 + 1] -= 1;
            diff[row2 + 1][col2 + 1] += 1; 
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int above = i > 0 ? grid[i - 1][j] : 0;
                int left = j > 0 ? grid[i][j - 1] : 0;
                int diag = ((i == 0) || (j == 0)) ? 0 : grid[i - 1][j - 1]; 
                grid[i][j] = diff[i][j] + above + left - diag;
            }
        }
        return grid;
    }
}