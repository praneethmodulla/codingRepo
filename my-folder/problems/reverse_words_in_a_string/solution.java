class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb.append(str[str.length - 1 - i] + " ");
        } 
        return sb.toString().trim();
    }
}