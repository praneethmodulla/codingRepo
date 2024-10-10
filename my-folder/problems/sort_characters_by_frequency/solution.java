class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((n1, n2) -> count.get(n2) - count.get(n1));
        for(Character ch : count.keySet()){
            maxHeap.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size() != 0){
            char ch = maxHeap.remove();
            for(int i = 0; i < count.get(ch); i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}