class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){ 
            if(!st.isEmpty() && (asteroids[i] < 0 && st.peek() > 0)){
                while(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0){
                    if(Math.abs(asteroids[i]) > st.peek()){
                        st.pop();
                    } else {
                        break;
                    }
                }
                if(st.isEmpty()){
                    st.push(asteroids[i]);
                } else if(st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                } else if(!st.isEmpty() && st.peek() < 0){
                    st.push(asteroids[i]);
                }
            } else {
                st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}