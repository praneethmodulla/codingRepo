class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int rep = 1;
        Stack<Character> st = new Stack<Character>();
        while(i < s.length()){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
                i++;
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                StringBuilder num = new StringBuilder();
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num.append(s.charAt(i));
                    i++;
                }
                rep = Integer.parseInt(num.toString());
            } else {
                st.push(s.charAt(i));
                i++;
                StringBuilder newString = new StringBuilder();
                while(!st.isEmpty()){
                    if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                        newString.append(s.charAt(i));
                    } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        newString.append(s.charAt(i));
                    } else if(s.charAt(i) == '['){
                        newString.append(s.charAt(i));
                        st.push(s.charAt(i));
                    } else if(s.charAt(i) == ']' && st.size() > 1){
                        newString.append(s.charAt(i));
                        st.pop();
                    } else {
                        st.pop();
                    }
                    i++;
                }
                String dSt = decodeString(newString.toString());
                for(int j = 0; j < rep; j++){
                    sb.append(dSt);
                }
                rep = 1;
            }
        }
        StringBuilder finalString = new StringBuilder();
        for(int j = 0; j < rep; j++){
            finalString.append(sb.toString());
        }
        return finalString.toString();
    }
}