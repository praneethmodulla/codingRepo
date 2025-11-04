class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<Character>();
        HashSet<Character> seen = new HashSet<Character>();
        HashMap<Character, Integer> last = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            last.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++){
            if(!seen.contains(s.charAt(i))){
                while(!st.isEmpty() && st.peek() > s.charAt(i) && last.get(st.peek()) > i){
                    seen.remove(st.pop());
                }
                st.push(s.charAt(i));
                seen.add(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}