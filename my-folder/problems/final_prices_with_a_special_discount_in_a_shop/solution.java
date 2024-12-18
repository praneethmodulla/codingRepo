class Solution {
    public int[] finalPrices(int[] prices) {
        int[] results = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < prices.length; i++){
            results[i] = prices[i];
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                results[stack.peek()] = results[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return results;
    }
}