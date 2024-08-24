class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] strArray = strs[i].toCharArray();
            Arrays.sort(strArray);
            String str = new String(strArray);
            List<String> s = new ArrayList<>();
            if(map.containsKey(str)){
                s = map.get(str);
                s.add(strs[i]);
                map.put(str, s);
            } else {
                s.add(strs[i]);
                map.put(str, s);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(String s : map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }
}