class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while(i < pushed.length && j < popped.length){
            if(st.isEmpty()){
                st.push(pushed[i]);
                i++;
            } else if(st.peek() == popped[j]){
                st.pop();
                j++;
            } else {
                st.push(pushed[i]);
                i++;
            }
        }
        while(j < popped.length){
            if(st.peek() == popped[j]){
                st.pop();
                j++;
            } else {
                break;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}