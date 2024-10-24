class Pair{
    int row;
    int col;
    int time;
    Pair(int _row, int _col, int _tm){
        row = _row;
        col = _col;
        time = _tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int cntFresh = 0;
        int cnt = 0;
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    queue.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int time = 0;
        int[] dRow = {-1, 0, +1, 0};
        int[] dCol = {0, -1, 0, +1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int tm = p.time;
            time = Math.max(time, tm);
            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow < grid.length && nRow >= 0 && nCol < grid[0].length && nCol >= 0 && grid[nRow][nCol] == 1 && vis[nRow][nCol] != 2){
                    vis[nRow][nCol] = 2;
                    queue.add(new Pair(nRow, nCol, tm + 1));
                    cnt++;
                } 
            }
        }
        if(cnt != cntFresh){
            return -1;
        }
        return time;
    }
}