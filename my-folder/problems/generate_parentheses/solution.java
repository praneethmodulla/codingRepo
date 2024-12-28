class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        recurse(sb, result, stack, n);
        return result;
    }

    public void recurse(StringBuilder sb, List<String> res, Stack st, int n){
        if(st.isEmpty() && n == 0){
            res.add(sb.toString());
            return;
        }

        if(st.isEmpty() && n > 0){
            sb.append("(");
            st.push('(');
            recurse(sb, res, st, n - 1);
            sb.deleteCharAt(sb.length() - 1);
            st.pop();
        } else if(!st.isEmpty() && n > 0){
            sb.append("(");
            st.push('(');
            recurse(sb, res, st, n - 1);
            sb.deleteCharAt(sb.length() - 1);
            st.pop();
            sb.append(")");
            st.pop();
            recurse(sb, res, st, n);
            sb.deleteCharAt(sb.length() - 1);
            st.push('(');
        } else {
            sb.append(")");
            st.pop();
            recurse(sb, res, st, n);
            sb.deleteCharAt(sb.length() - 1);
            st.push('(');
        }
        return;
    }
}