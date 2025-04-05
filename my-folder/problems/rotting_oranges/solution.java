class Pair{
    int row;
    int col;
    int time;
    public Pair(int _row, int _col, int _time){
        this.row = _row;
        this.col = _col;
        this.time = _time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        int maxTime = 0;
        int[] dRow = new int[]{0, 1, -1, 0};
        int[] dCol = new int[]{1, 0, 0, -1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            maxTime = Math.max(maxTime, time);
            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = 2;
                    queue.add(new Pair(nRow, nCol, time + 1));
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return maxTime;
    }
}