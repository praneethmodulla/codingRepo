class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return Double.compare((double)a[0]/a[1], (double)b[0]/b[1]);
        });
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                heap.add(new int[]{arr[i], arr[j]});
            }
        }
        for(int i = 0; i < k - 1; i++){
            heap.poll();
        }
        return heap.peek();
    }
}