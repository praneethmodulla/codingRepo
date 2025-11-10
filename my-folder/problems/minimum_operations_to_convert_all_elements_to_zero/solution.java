class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            while(!st.isEmpty() && st.peek() > nums[i]){
                st.pop();
            }
            if(nums[i] == 0){
                continue;
            }
            if(st.isEmpty() || st.peek() < nums[i]){
                st.add(nums[i]);
                count++;
            }
        }
        return count;
    }
}