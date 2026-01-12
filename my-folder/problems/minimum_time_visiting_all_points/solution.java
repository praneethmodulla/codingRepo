class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for(int i = 0; i < points.length - 1; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];
            int dy = Math.abs(y2 - y1);
            int dx = Math.abs(x2 - x1); 
            int op1 = dx + dy;
            int op2 = Math.max(dx, dy);
            time += Math.min(op1, op2);
        }
        return time;
    }
}