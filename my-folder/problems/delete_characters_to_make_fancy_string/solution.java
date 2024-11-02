class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() <= 2){
            return s;
        }
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i - 1) && s.charAt(i) != s.charAt(i - 2)){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) != s.charAt(i - 2) || s.charAt(i) != s.charAt(i - 1)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}