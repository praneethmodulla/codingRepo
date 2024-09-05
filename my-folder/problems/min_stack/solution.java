class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!minStack.isEmpty() && minStack.peek() >= val){
            minStack.push(val);
        }
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        return;
    }
    
    public void pop() {
        int stackTop = st.peek();
        int minStacktop = minStack.peek();
        if(stackTop == minStacktop){
            minStack.pop();
        }
        st.pop();
        return;
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */