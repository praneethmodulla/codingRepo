class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            hMap.put(s.charAt(i), hMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> Character.compare(b, a));
        for(char ch : hMap.keySet()){
            maxHeap.add(ch);
        }
        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            int count = hMap.get(ch);
            int use = Math.min(count, repeatLimit);
            for(int i = 0; i < use; i++){
                sb.append(ch);
            }
            hMap.put(ch, hMap.get(ch) - use);
            if(hMap.get(ch) > 0 && !maxHeap.isEmpty()){
                char nextCh = maxHeap.poll();
                sb.append(nextCh);
                hMap.put(nextCh, hMap.get(nextCh) - 1);
                if(hMap.get(nextCh) > 0){
                    maxHeap.add(nextCh);
                }
                maxHeap.add(ch);
            }
        }
        return sb.toString();
    }
}