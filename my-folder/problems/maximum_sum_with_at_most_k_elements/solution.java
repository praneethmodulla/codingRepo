class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                maxHeap.add(new int[]{grid[i][j], i});
            }
        }
        long maxSum = 0;
        int i = 0;
        while(i < k){
            int[] val = maxHeap.poll();
            if(limits[val[1]] != 0){
                maxSum += val[0];
                limits[val[1]]--;
                i++;
            }
        }
        return maxSum;
    }
}