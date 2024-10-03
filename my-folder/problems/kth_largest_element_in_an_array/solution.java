class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            heap.add(nums[i]);
        }
        while(heap.size() > k){
            heap.remove();
        }
        return heap.remove();
    }
}