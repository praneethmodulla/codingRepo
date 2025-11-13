class Solution {
    public int maxOperations(String s) {
        int ops = 0;
        int count = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '1'){
                count++;
                i++;
            } else {
                while(i < s.length() && s.charAt(i) == '0'){
                    i++;
                }
                ops += count;
            }
        }
        return ops;
    }
}