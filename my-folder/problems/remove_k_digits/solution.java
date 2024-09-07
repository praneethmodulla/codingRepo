class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < num.length(); i++){
            while(!st.isEmpty() && k > 0 && ((st.peek() - '0') > num.charAt(i) - '0')){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res = res.append(st.pop());
        }
        while(res.length() != 0 && res.charAt(res.length() - 1) == '0'){
            res.deleteCharAt(res.length() - 1);
        }
        if(res.length() == 0){
            return "0";
        }
        return res.reverse().toString();
    }
}