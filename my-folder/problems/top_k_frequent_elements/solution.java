class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)-> map.get(n1) - map.get(n2));
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Integer i : map.keySet()){
            heap.add(i);
            if(heap.size() > k){
                heap.remove();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while(i < k){
            result[i] = heap.remove();
            i++;
        }
        return result;
    }
}