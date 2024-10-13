class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxDepth = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            } else if(s.charAt(i) == ')'){
                if(maxDepth < st.size()){
                    maxDepth = st.size();
                }
                st.pop();
            }
        }
        return maxDepth;
    }
}