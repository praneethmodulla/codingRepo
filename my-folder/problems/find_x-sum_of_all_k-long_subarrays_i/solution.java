class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++){
            ans[i] = xSum(nums, i, i + k - 1, x);
        }
        return ans;
    }

    public int xSum(int[] nums, int left, int right, int x){
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> {
            int diff = hMap.get(a) - hMap.get(b);
            if(diff == 0){
                return Integer.compare(b, a);
            } else {
                return Integer.compare(hMap.get(b), hMap.get(a));
            }
        });
        for(int i = left; i <= right; i++){
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
        }
        for(int i : hMap.keySet()){
            heap.add(i);
        }
        int ans = 0;
        while(!heap.isEmpty() && x > 0){
            int num = heap.poll();
            ans += num * hMap.get(num);
            x--;
        }
        return ans;
    }
}