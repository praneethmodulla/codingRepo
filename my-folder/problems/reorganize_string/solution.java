class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
                pq.add(new int[]{i + 'a', freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != (char)first[0]){
                sb.append((char)first[0]);
                if(first[1] - 1 != 0){
                    pq.add(new int[]{first[0], first[1] - 1});
                }
            } else {
                if(pq.isEmpty()){
                    return "";
                } else {
                    int[] second = pq.poll();
                    sb.append((char)second[0]);
                    if(second[1] - 1 != 0){
                        pq.add(new int[]{second[0], second[1] - 1});
                    }
                    pq.add(first);
                }
            } 
        }
        return sb.toString();
    }
}