class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            hMap.put(s.charAt(i), hMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            if(hMap.containsKey(order.charAt(i))){
                int rep = hMap.get(order.charAt(i));
                while(rep > 0 ){
                    sb.append(order.charAt(i));
                    rep--;
                }
                hMap.remove(order.charAt(i));
            }
        }
        for(char c : hMap.keySet()){
            int rep = hMap.get(c);
            while(rep > 0){
                sb.append(c);
                rep--;
            }
        }
        return sb.toString();
    }
}