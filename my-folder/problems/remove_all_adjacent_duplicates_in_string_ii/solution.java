class Pair{
    char ch;
    int freq;
    public Pair(char c, int freq){
        this.ch = c;
        this.freq = freq;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(s.charAt(0), 1));
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek().ch == s.charAt(i)){
                Pair p = stack.pop();
                if(p.freq + 1 < k){
                    stack.push(new Pair(p.ch, p.freq + 1));
                }
            } else {
                stack.push(new Pair(s.charAt(i), 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            while(p.freq > 0){
                sb.append(p.ch);
                p.freq--;
            }
        }
        return sb.reverse().toString();
    }
}