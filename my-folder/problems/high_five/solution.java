class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < items.length; i++){
            if(map.containsKey(items[i][0])){
                map.get(items[i][0]).add(items[i][1]);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
                pq.add(items[i][1]);
                map.put(items[i][0], pq);
            }
        }
        int[][] result = new int[map.size()][2];
        int i = 0;
        for(int id : map.keySet()){
            PriorityQueue<Integer> heap = map.get(id);
            int count = 5;
            int sum = 0;
            while(count > 0){
                sum += heap.poll();
                count--;
            }
            result[i][0] = id;
            result[i][1] = sum/5; 
            i++;
        }
        return result;
    }
}