class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[temperatures.length];
        ans[temperatures.length - 1] = 0;
        stack.push(temperatures.length - 1);
        for(int i = temperatures.length - 2; i >= 0; i--){
            int cnt = 1;
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                cnt += ans[stack.peek()];
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = 0;
                stack.push(i);
            } else {
                ans[i] = cnt;
                stack.push(i);
            }
        }
        return ans;
    }
}