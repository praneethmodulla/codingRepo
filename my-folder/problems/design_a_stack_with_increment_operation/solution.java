class CustomStack {
    List<Integer> list;
    int capacity;
    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        list = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        if(list.size() < capacity){
            list.add(x);
        }
    }
    
    public int pop() {
        if(list.size() == 0){
            return -1;
        }
        int value = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return value;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, list.size()); i++){
            int value = list.get(i);
            value += val;
            list.set(i, value);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */