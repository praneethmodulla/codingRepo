class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '(' && s.charAt(i) != ')'){
                sb.append(s.charAt(i));
            } else {
                if(s.charAt(i) == '('){
                    stack.push(s.charAt(i));
                    sb.append(s.charAt(i));
                } else if(s.charAt(i) == ')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                        sb.append(s.charAt(i));
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return sb.toString();
        }
        int redundant = stack.size();
        Stack<Character> stRev = new Stack<Character>();
        StringBuilder sbReverse = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--){
            if(sb.charAt(i) != '(' && sb.charAt(i) != ')'){
                sbReverse.append(sb.charAt(i));
            } else {
                if(sb.charAt(i) == ')'){
                    stRev.push(sb.charAt(i));
                    sbReverse.append(sb.charAt(i));
                } else {
                    if(!stRev.isEmpty()){
                        stRev.pop();
                        sbReverse.append(sb.charAt(i));
                    }
                }
            }
        }
        StringBuilder sbFinal = new StringBuilder();
        for(int i = sbReverse.length() - 1; i >= 0; i--){
            sbFinal.append(sbReverse.charAt(i));
        }
        return sbFinal.toString();
    }
}