class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].length() == 1 && (tokens[i].charAt(0) == '+' || tokens[i].charAt(0) == '-' || tokens[i].charAt(0) == '/' || tokens[i].charAt(0) == '*')){
                int num1 = st.pop();
                int num2 = st.pop();
                if(tokens[i].charAt(0) == '+'){
                    ans = num1 + num2;
                } else if(tokens[i].charAt(0) == '-'){
                    ans = num2 - num1;
                } else if(tokens[i].charAt(0) == '/'){
                    ans = num2/num1;
                } else {
                    ans = num1 * num2;
                }
                st.push(ans);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}