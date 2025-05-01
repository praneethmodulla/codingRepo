class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] st = path.split("/");
        for(int i = 0; i < st.length; i++){
            if(!st[i].isBlank()){
                if(st[i].equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else if(st[i].equals(".")){
                    continue;
                } else {
                    stack.push(st[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> revStack = new Stack<String>();
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            revStack.push(stack.pop());
        }
        sb.append("/");
        while(!revStack.isEmpty()){
            sb.append(revStack.pop() + "/");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}