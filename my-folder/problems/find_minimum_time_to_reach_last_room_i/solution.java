class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        int[][] vis = new int[rows][cols];
        int minTime = Integer.MAX_VALUE;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        int[] dRow = new int[]{1, 0, 0, -1};
        int[] dCol = new int[]{0, 1, -1, 0};
        queue.add(new Pair(0, 0, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            if(vis[row][col] == 1){
                continue;
            }
            vis[row][col] = 1;
            if(row == rows - 1 && col == cols - 1){
                minTime = Math.min(minTime, time);
                break;
            }
            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols) {
                    continue;
                }
                if(vis[nRow][nCol] != 1){
                    if(moveTime[nRow][nCol] <= time){
                        queue.add(new Pair(nRow, nCol, time + 1));
                    } else {
                        queue.add(new Pair(nRow, nCol, moveTime[nRow][nCol] + 1));
                    }
                }
            }
        }
        return minTime;
    }
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int time;
        public Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.time, other.time);
        }
    }
}