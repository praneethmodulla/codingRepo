class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int nse = i;
                int height = st.pop();
                int pse = -1;
                if(!st.isEmpty()){
                    pse = st.peek();
                }
                maxi = Math.max(maxi, heights[height] * (nse - pse - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            int nse = heights.length;
            int pse = -1;
            if(!st.isEmpty()){
                pse = st.peek();
            }
            maxi = Math.max(maxi, heights[idx] * (nse - pse - 1));
        }
        return maxi;
    }
}