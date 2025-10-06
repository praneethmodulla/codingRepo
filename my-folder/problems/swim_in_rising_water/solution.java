class Pair{
    int row;
    int col;
    int time;

    public Pair(int _row, int _col, int _time){
        row = _row;
        col = _col;
        time = _time; 
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b)->Integer.compare(a.time, b.time));
        queue.add(new Pair(0, 0, grid[0][0]));
        int[][] vis = new int[grid.length][grid[0].length];
        for(int[] row : vis){
            Arrays.fill(row, 0);
        }
        vis[0][0] = 1;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int i = p.row;
            int j = p.col;
            int time = p.time;
            if(i == grid.length - 1 && j == grid[0].length - 1){
                return time;
            }
            int[] dCol = new int[]{0, -1, 1, 0};
            int[] dRow = new int[]{-1, 0, 0, 1};
            for(int k = 0; k < 4; k++){
                int nRow = i + dRow[k];
                int nCol = j + dCol[k];
                if(nRow < grid.length && nCol < grid[0].length && nRow >= 0 && nCol >= 0 && vis[nRow][nCol] != 1){
                    vis[nRow][nCol] = 1;
                    queue.add(new Pair(nRow, nCol, time + Math.max(0, grid[nRow][nCol] - time)));
                }
            }
        }
        return 0;
    }
}