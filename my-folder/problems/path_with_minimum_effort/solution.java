class Pair {
    int row;
    int col;
    int maxEffort;
    public Pair(int _row, int _col, int _max){
        row = _row;
        col = _col;
        maxEffort = _max;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        if(rows == 1 && cols == 1){
            return 0;
        }
        int[][] vis = new int[heights.length][heights[0].length];
        for(int[] row : vis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        vis[0][0] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x, y) -> x.maxEffort - y.maxEffort);
        queue.add(new Pair(0, 0, 0));
        int[] dRow = {0, 1, -1, 0};
        int[] dCol = {1, 0, 0, -1};
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int effort = pair.maxEffort;
            if(row == heights.length - 1 && col == heights[0].length - 1){
                return vis[row][col];
            }            
            for(int i = 0; i < dRow.length; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < heights.length && nCol >= 0 && nCol < heights[0].length){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), effort);
                    if(newEffort < vis[nRow][nCol]){
                        vis[nRow][nCol] = newEffort;
                        queue.add(new Pair(nRow, nCol, newEffort));
                    }
                }
            }
        }
        return ans;
    }
}