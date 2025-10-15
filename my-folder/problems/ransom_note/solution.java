class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < ransomNote.length(); i++){
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for(int i = 0; i < magazine.length(); i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) - 1);
                if(map.get(magazine.charAt(i)) == 0){
                    map.remove(magazine.charAt(i));
                }
            }
        }
        if(map.size() == 0){
            return true;
        }
        return false;
    }
}