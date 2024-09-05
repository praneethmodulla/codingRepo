class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.add(x);
    }
    
    public int pop() {
        int size = queue1.size();
        int ans = 0;
        for(int i = 0; i < size; i++){
            if(i == size - 1){
                ans = queue1.remove();
            } else {
                queue2.add(queue1.remove());
            }
        }
        size = queue2.size();
        for(int i = 0; i < size; i++){
            queue1.add(queue2.remove());
        }
        return ans;
    }
    
    public int top() {
        int size = queue1.size();
        int ans = 0;
        for(int i = 0; i < size; i++){
            if(i == size - 1){
                ans = queue1.peek();
            }
            queue2.add(queue1.remove());
        }
        size = queue2.size();
        for(int i = 0; i < size; i++){
            queue1.add(queue2.remove());
        }
        return ans;
    }
    
    public boolean empty() {
        if(queue1.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */