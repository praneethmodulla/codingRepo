class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<Character>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int j = s.length() - 1;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
            } else {
                while(j >= 0 && !set.contains(s.charAt(j))){
                    j--;
                }
                if(j >= 0){
                    sb.append(s.charAt(j));
                    j--;
                }
            }
            i++;
        }
        return sb.toString();
    }
}