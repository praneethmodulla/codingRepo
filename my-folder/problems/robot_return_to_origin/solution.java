class Solution {
    public boolean judgeCircle(String moves) {
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        for(int i = 0; i < moves.length(); i++){
            hMap.put(moves.charAt(i), hMap.getOrDefault(moves.charAt(i), 0) + 1);
        }
        int ups = hMap.getOrDefault('U', 0);
        int downs = hMap.getOrDefault('D', 0);
        int lefts = hMap.getOrDefault('L', 0);
        int rights = hMap.getOrDefault('R', 0);
        if((ups == downs) && (lefts == rights)){
            return true;
        }
        return false;
    }
}