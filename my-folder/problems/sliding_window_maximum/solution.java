class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(nums[b], nums[a]));
        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(right = 0 ; right < k; right++){
            maxHeap.add(right);
        }
        res.add(nums[maxHeap.peek()]);
        for(right = k; right < nums.length; right++){
            left++;
            maxHeap.add(right);
            if(left <= maxHeap.peek()){
                res.add(nums[maxHeap.peek()]);
            } else {
                while(maxHeap.peek() < left){
                    maxHeap.poll();
                }
                res.add(nums[maxHeap.peek()]);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }
}