class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int[] count = new int[26];
        for(int i = 0; i < strs.length; i++){
            Arrays.fill(count, 0);
            for(int j = 0; j < strs[i].length(); j++){
                count[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < 26; k++){
                sb.append("#");
                sb.append(count[k]);
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(strs[i]);
            } else {
                map.put(sb.toString(), new ArrayList<String>());
                map.get(sb.toString()).add(strs[i]);
            }
        }
        for(String s : map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }
}