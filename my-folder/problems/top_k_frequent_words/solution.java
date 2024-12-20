class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        PriorityQueue<String> heap = new PriorityQueue<String>((a, b) -> {
            if(hMap.get(b) - hMap.get(a) == 0){
                return a.compareTo(b);
            }
            return hMap.get(b) - hMap.get(a);
        });
        for(int i = 0; i < words.length; i++){
            hMap.put(words[i], hMap.getOrDefault(words[i], 0) + 1);
        }
        for(String word : hMap.keySet()){
            heap.add(word);
        }
        while(!heap.isEmpty() && k-- > 0){
            result.add(heap.poll());
        }
        return result;
    }
}