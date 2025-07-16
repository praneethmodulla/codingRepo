class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        StringBuilder sbRev = new StringBuilder();
        for(int i = sb.length() - 1; i >=0; i--){
            sbRev.append(sb.charAt(i));
        }
        return sbRev.toString();
    }
}