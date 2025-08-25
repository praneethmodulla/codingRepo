class Solution {
    public int minimumArea(int[][] grid) {
        int minTop = Integer.MAX_VALUE;
        int minBottom = Integer.MIN_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    minTop = Math.min(minTop, i);
                    minBottom = Math.max(minBottom, i);
                    minLeft = Math.min(minLeft, j);
                    minRight = Math.max(minRight, j);
                }
            }
        }
        return (minBottom - minTop + 1) * (minRight - minLeft + 1);
    }
}