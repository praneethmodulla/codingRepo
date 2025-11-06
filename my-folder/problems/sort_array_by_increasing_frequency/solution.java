class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            int diff = hMap.get(a) - hMap.get(b);
            if(diff == 0){
                return Integer.compare(b, a);
            } else {
                return Integer.compare(hMap.get(a), hMap.get(b));
            }
        });
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
        } 
        for(int i : hMap.keySet()){
            heap.add(i);
        }
        int i = 0;
        while(!heap.isEmpty()){
            int num = heap.poll();
            int freq = hMap.get(num);
            while(freq > 0){
                res[i] = num;
                freq--;
                i++;
            }
        }
        return res;
    }
}