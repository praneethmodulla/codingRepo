class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        int minRooms = 0;
        for(int i = 0; i < intervals.length; i++){
            minHeap.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        int[] prev = minHeap.poll();
        minRooms++;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> Integer.compare(a, b));
        heap.add(prev[1]);
        while(!minHeap.isEmpty()){
            int[] var = minHeap.poll();
            if(heap.peek() > var[0]){
                minRooms++;
                heap.add(var[1]);
            } else {
                heap.poll();
                heap.add(var[1]);
            }
        }
        return minRooms; 
    }
}