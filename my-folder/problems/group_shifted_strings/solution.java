class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> hMap = new HashMap<String, List<String>>();
        for(int i = 0; i < strings.length; i++){
            String s = getHash(strings[i]);
            if(hMap.containsKey(s)){
                hMap.get(s).add(strings[i]);
            } else {
                hMap.put(s, new ArrayList<String>());
                hMap.get(s).add(strings[i]);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(String s : hMap.keySet()){
            result.add(hMap.get(s));
        }
        return result;
    }
    public String getHash(String s){
        char[] charArray = s.toCharArray();
        StringBuilder hash = new StringBuilder();
        for(int i = 1; i < charArray.length; i++){
            hash.append((char)((charArray[i] - charArray[i - 1] + 26)%26 + 'a'));
        }
        return hash.toString();
    }
}