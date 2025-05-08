class Pair{
    int row;
    int col;
    int time;
    int cnt;
    public Pair(int r, int c, int t, int count){
        this.row = r;
        this.col = c;
        this.time = t;
        this.cnt = count;
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] vis = new int[n][m];
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b) -> Integer.compare(a.time, b.time));
        queue.add(new Pair(0,0,0,1));
        int[] dRow = new int[]{0, -1, 1, 0};
        int[] dCol = new int[]{1, 0, 0, -1};
        int minTime = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            int count = p.cnt;
            int val = 0;
            if(row == n - 1 && col == m - 1){
                minTime = Math.min(minTime, time);
                break;
            }
            if(count % 2 == 1){
                val = 1;
            } else {
                val = 2;
            }
            if(vis[row][col] == 1){
                continue;
            }
            vis[row][col] = 1;
            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow < 0 || nRow >=n || nCol < 0 || nCol >= m){
                    continue;
                } 
                int nTime = Math.max(moveTime[nRow][nCol] + val, time + val);
                queue.add(new Pair(nRow, nCol, nTime, count + 1));
            }
        }
        return minTime;
    }
}