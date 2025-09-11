class Solution {
    public String sortVowels(String s) {
        List<Character> chars = new ArrayList<Character>();
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                chars.add(s.charAt(i));
            }
        }
        Collections.sort(chars);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                sb.append(chars.get(j));
                j++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}