class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] idx = new int[2];
        Arrays.fill(idx, -1);
        for(right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(freq.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            while(map.size() == freq.size() && check(map, freq)){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    idx[0] = left;
                    idx[1] = right;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if(map.get(s.charAt(left)) == 0){
                        map.remove(s.charAt(left));
                    }
                }
                left++;
            }
        }
        if(idx[0] == -1){
            return "";
        }
        return s.substring(idx[0], idx[1] + 1);
    }

    public boolean check(HashMap<Character, Integer> mp, HashMap<Character, Integer> freq){
        for(char c : freq.keySet()){
            if(mp.get(c) < freq.get(c)){
                return false;
            }
        }
        return true;
    }
}