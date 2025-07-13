class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        for(int i = 0; i < stones.length; i++){
            heap.add(stones[i]);
        }
        while(heap.size() > 1 && !heap.isEmpty()){
            int first = heap.poll();
            int second = heap.poll();
            if(first == second){
                continue;
            } else {
                heap.add(Math.abs(first - second));
            }
        }
        if(!heap.isEmpty()){
            return heap.poll();
        }
        return 0;
    }
}