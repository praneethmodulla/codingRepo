class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, List<Character>> hmap = new HashMap<String, List<Character>>();
        char ch = 'a';
        for(int i = 2; i <= 9; i++){
            List<Character> stringList = new ArrayList<Character>();
            if(i == 7 || i == 9){
                stringList.add(ch++);
                stringList.add(ch++);
                stringList.add(ch++);
                stringList.add(ch++);
            } else {
                stringList.add(ch++);
                stringList.add(ch++);
                stringList.add(ch++);
            }
            hmap.put(String.valueOf(i), stringList);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recurse(hmap, res, digits, 0, sb);
        return res;
    }

    public void recurse(HashMap<String, List<Character>> hMap, List<String> result, String digits, int idx, StringBuilder sb){
        if(idx == digits.length()){
            if(digits.length() == 0){
                return;
            }
            String str = sb.toString();
            result.add(str);
            return;
        }
        char ch = digits.charAt(idx);
        List<Character> list = hMap.get(String.valueOf(ch));
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
            recurse(hMap, result, digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}