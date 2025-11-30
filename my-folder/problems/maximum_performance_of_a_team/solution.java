class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < speed.length; i++){
            heap.add(new int[]{efficiency[i], speed[i]});
        }
        int m = (int)1e9 + 7;
        PriorityQueue<Integer> speedHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(a,b));
        long performance = 0;
        long speedSum = 0;
        List<int[]> engineer = new ArrayList<int[]>();
        while(!heap.isEmpty()){
            engineer.add(heap.poll());
        }
        for(int i = 0; i < engineer.size(); i++){
            int speedData = engineer.get(i)[1];
            int efficiencyData = engineer.get(i)[0];
            while(speedHeap.size() > k - 1){
                speedSum -= speedHeap.poll();
            } 
            speedHeap.add(speedData);
            speedSum += speedData;
            performance = Math.max(performance, speedSum * efficiencyData);
        }
        return (int)(performance % m);
    }
}