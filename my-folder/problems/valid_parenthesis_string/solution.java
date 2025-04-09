class Solution {
    public boolean checkValidString(String s) {
        int op = 0;
        int cl = 0;
        int st = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                op++; 
            } else if(s.charAt(i) == ')'){
                if(op > 0){
                    op--;
                } else if(st > 0){
                    st--;
                } else {
                    return false;
                }
            } else if(s.charAt(i) == '*'){
                st++;
            }
        }
        op = 0;
        cl = 0;
        st = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '('){
                if(cl > 0){
                    cl--;
                } else if(st > 0){
                    st--;
                } else {
                    return false;
                }
            } else if(s.charAt(i) == ')'){
                cl++;
            } else if(s.charAt(i) == '*'){
                st++;
            }
        }
        return true;
    }
}