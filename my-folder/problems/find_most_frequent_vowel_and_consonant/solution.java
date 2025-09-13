class Solution {
    public int maxFreqSum(String s) {
        int maxC = 0;
        int maxV = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(char c : map.keySet()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                if(map.get(c) > maxV){
                    maxV = map.get(c);
                }
            } else {
                maxC = Math.max(maxC, map.get(c));
            }
        }
        return maxC + maxV;
    }
}