class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(heights.length - 1);
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(heights.length - 1);
        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i] > heights[stack.peek()]){
                answer.add(i);
            }
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.add(i);
            }
        }
        int[] ans = new int[answer.size()];
        for(int i = answer.size() - 1; i >= 0; i--){
            ans[answer.size() - 1 - i] = answer.get(i);
        }
        return ans;
    }
}