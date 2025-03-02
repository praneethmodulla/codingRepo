class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return true;
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++){
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            sb.append(String.valueOf(((a + b)%10)));
        }
        return hasSameDigits(sb.toString());
    }
}