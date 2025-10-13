class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        int n = heights.length;
        res[heights.length - 1] = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(heights[n - 1]);
        for(int i = n - 2; i >= 0; i--){
            int count = 0;
            while(!st.isEmpty() && heights[i] > st.peek()){
                st.pop();
                count++;
            }
            if(!st.isEmpty()){
                count += 1;
            }
            res[i] = count;
            st.push(heights[i]);
        }
        return res;
    }
}