class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                heap.add(matrix[i][j]);
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }
        return heap.poll();
    }
}