class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            } else if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char ch = stack.pop();
            sb.append(ch);
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            sb2.append(sb.toString().charAt(sb.length() - 1 - i));
        }
        return sb2.toString();
    }
}