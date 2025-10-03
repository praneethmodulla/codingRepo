class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i) + 32));
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }
        }
        String str = sb.toString();
        int i = 0;
        int j = str.length() - 1;

        while(i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}