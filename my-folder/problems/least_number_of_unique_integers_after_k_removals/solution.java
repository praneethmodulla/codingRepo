class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> Integer.compare(hMap.get(a), hMap.get(b)));
        for(int i = 0; i < arr.length; i++){
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
        }
        for(int i : hMap.keySet()){
            heap.add(i);
        }
        while(k > 0){
            int num = heap.poll();
            hMap.put(num, hMap.get(num) - 1);
            if(hMap.get(num) == 0){
                hMap.remove(num);
            } else {
                heap.add(num);
            }
            k--;
        }
        return heap.size();
    }
}