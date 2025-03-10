class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> {
            double distA = Math.sqrt(Math.pow((a[0] - 0), 2) + Math.pow((a[1] - 0), 2));
            double distB = Math.sqrt(Math.pow((b[0] - 0), 2) + Math.pow((b[1] - 0), 2));
            return Double.compare(distA, distB);
        });
        for(int i = 0; i < points.length; i++){
            heap.add(points[i]);
        }
        int j = 0;
        while(j < k){
            int[] point = heap.poll();
            ans[j][0] = point[0];
            ans[j][1] = point[1];
            j++;
        }
        return ans;
    }
}