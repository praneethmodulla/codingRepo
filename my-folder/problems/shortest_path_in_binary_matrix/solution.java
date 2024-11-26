class Pair {
    int dist;
    int row;
    int col;

    public Pair(int _dist, int _row, int _col){
        dist = _dist;
        row = _row;
        col = _col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        for(int[] row : vis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        if(grid[0][0] != 0){
            return -1;
        }
        if(grid.length == 1){
            return 1;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, 0, 0));
        int[] drow = {0, 1, -1, 0, 1, 1, -1, -1};
        int[] dcol = {1, 0, 0, -1, 1, -1, 1, -1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int dist = pair.dist;
            int row = pair.row;
            int col = pair.col;
            for(int i = 0; i < drow.length; i++){
                int nRow = row + drow[i];
                int nCol = col + dcol[i];
                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 0 && dist + 1 < vis[nRow][nCol]){
                    if(nRow == grid.length - 1 && nCol == grid[0].length - 1){
                        return dist + 1 + 1;
                    }
                    vis[nRow][nCol] = dist + 1;
                    queue.add(new Pair(dist + 1, nRow, nCol));
                }
            }
        }
        return -1;
    }
}