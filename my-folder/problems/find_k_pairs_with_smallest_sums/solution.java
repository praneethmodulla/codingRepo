class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(maxHeap.size() < k){
                    maxHeap.add(new int[]{nums1[i], nums2[j]});
                } else {
                    if(nums1[i] + nums2[j] < maxHeap.peek()[0] + maxHeap.peek()[1]){
                        maxHeap.poll();
                        maxHeap.add(new int[]{nums1[i], nums2[j]});
                    } else {
                        break;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(!maxHeap.isEmpty()){
            int[] first = maxHeap.poll();
            List<Integer> res = new ArrayList<Integer>();
            res.add(first[0]);
            res.add(first[1]);
            result.add(res);
        }
        Collections.reverse(result);
        return result;
    }
}