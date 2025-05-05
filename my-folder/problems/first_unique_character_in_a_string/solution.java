class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            hMap.put(s.charAt(i), hMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(hMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}