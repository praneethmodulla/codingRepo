class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> {
            int absA = Math.abs(a - x);
            int absB = Math.abs(b - x);
            if(absA == absB){
                return a - b;
            } else {
                return absA - absB;
            }
        });
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }
        while(k > 0){
            result.add(heap.poll());
            k--;
        }
        Collections.sort(result);
        return result;
    }
}