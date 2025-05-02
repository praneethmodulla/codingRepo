class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char operation = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(currentChar >= '0' && currentChar <= '9'){
                num = (num * 10) + (currentChar - '0');
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1){
                if(operation == '+'){
                    stack.push(num);
                } else if(operation == '-'){
                    stack.push(-num);
                } else if(operation == '*'){
                    stack.push(stack.pop() * num);
                } else if(operation == '/'){
                    stack.push(stack.pop()/num);
                }
                operation = currentChar;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}