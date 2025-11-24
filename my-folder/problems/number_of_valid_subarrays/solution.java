class Solution {
    public int validSubarrays(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        int[] nse = new int[nums.length];
        nse[nums.length - 1] = nums.length;
        st.push(nums.length - 1);
        for(int i = nums.length - 2; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = nums.length;
            } else {
                if(nums[i] == nums[st.peek()]){
                    nse[i] = nse[st.peek()];
                } else {
                    nse[i] = st.peek();
                }
            }
            st.push(i);
        }
        int number = 0;
        for(int i = 0; i < nums.length; i++){
            number += nse[i] - i;
        }
        return number;
    }
}