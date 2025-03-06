class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i = 0; i < boxTypes.length; i++){
            maxHeap.add(new int[]{boxTypes[i][0], boxTypes[i][1]});
        }
        int maxUnits = 0;
        while(!maxHeap.isEmpty() && truckSize > 0){
            int[] box = maxHeap.poll();
            if(truckSize >= box[0]){
                maxUnits += (box[0] * box[1]);
                truckSize -= box[0];
            } else {
                maxUnits += (truckSize * box[1]);
                truckSize -= truckSize;
            }
        }
        return maxUnits;
    }
}