class Solution {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}