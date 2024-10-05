class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }
        }
        String finalString = sb.toString();
        System.out.println(finalString);
        for(int i = 0; i < finalString.length()/2; i++){
            if(finalString.charAt(i) != finalString.charAt(finalString.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}