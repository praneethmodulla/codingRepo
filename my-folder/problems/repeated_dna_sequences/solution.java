class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() <= 10){
            return result;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i++){
            if(i + 9 >= s.length()){
                break;
            }
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(String st : map.keySet()){
            if(map.get(st) > 1){
                result.add(st);
            }
        }
        return result;
    }
}