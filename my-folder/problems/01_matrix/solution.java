class Pair{
    int row;
    int col;
    int steps;
    public Pair(int _row, int _col, int _steps){
        row = _row;
        col = _col;
        steps = _steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] vis = new int[mat.length][mat[0].length];
        int[][] dist = new int[mat.length][mat[0].length];
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    queue.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] dRow = {0, 1, -1, 0};
        int[] dCol = {1, 0, 0, -1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int steps = p.steps;
            dist[row][col] = steps;
            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < mat.length && nCol >= 0 && nCol < mat[0].length && vis[nRow][nCol] == 0){
                    vis[nRow][nCol] = 1;
                    queue.add(new Pair(nRow, nCol, steps + 1));
                }
            }
        }
        return dist;
    }
}