class MovingAverage {
    int windowSize;
    Queue<Integer> queue = new ArrayDeque<Integer>();
    double sum = 0;
    public MovingAverage(int size) {
        this.windowSize = size;
    }
    
    public double next(int val) {
        if(queue.size() < windowSize){
            queue.add(val);
            sum += val;
            return sum/queue.size();
        } else {
            sum -= queue.poll();
            queue.add(val);
            sum += val;
            return sum/windowSize;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */