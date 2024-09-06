class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<Integer>();

        for(int i = (2*nums.length - 1); i >= 0; i--){
            while(!st.isEmpty() && nums[i % nums.length] >= st.peek()){
                st.pop();
            }
            if(i < nums.length){
                if(!st.isEmpty()){
                    nge[i] = st.peek();
                } else {
                    nge[i] = -1;
                }
            }
            st.push(nums[i % nums.length]);
        }
        return nge;
    }
}