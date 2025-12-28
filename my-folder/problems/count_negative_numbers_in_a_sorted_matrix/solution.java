class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int i = grid.length - 1;
        int j = grid[0].length - 1;
        for(i = grid.length - 1; i >= 0; i--){
            for(j = grid[0].length - 1; j >= 0; j--){
                if(grid[i][j] < 0){
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}