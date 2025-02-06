class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxValinc = 0;
        for(int i = 0; i < nums.length; i++){
            if(!stack.isEmpty() && nums[i] > stack.peek()){
                stack.push(nums[i]);
            } else if(!stack.isEmpty() && nums[i] <= stack.peek()){
                while(!stack.isEmpty()){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }
            if(maxValinc < stack.size()){
                maxValinc = stack.size();
            }
        }
        Stack<Integer> stack2 = new Stack<Integer>();
        int maxValdec = 0;
        for(int i = 0; i < nums.length; i++){
            if(!stack2.isEmpty() && nums[i] < stack2.peek()){
                stack2.push(nums[i]);
            } else if(!stack2.isEmpty() && nums[i] >= stack2.peek()){
                while(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            if(stack2.isEmpty()){
                stack2.push(nums[i]);
            }
            if(maxValdec < stack2.size()){
                maxValdec = stack2.size();
            }
        }
        return maxValinc > maxValdec ? maxValinc : maxValdec;
    }
}