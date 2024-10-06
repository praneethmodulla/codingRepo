class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> hMap = new HashMap<Character, Character>();
        hMap.put(s.charAt(0), t.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(hMap.containsKey(s.charAt(i))){
                if(hMap.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            } else if(hMap.containsValue(t.charAt(i))){
                return false;
            }
            hMap.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}