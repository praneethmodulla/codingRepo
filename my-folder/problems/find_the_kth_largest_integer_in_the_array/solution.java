class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<String>((a,b)-> {
            if(a.length() < b.length()){
                return -1;
            } else if(a.length() > b.length()){
                return 1;
            } else {
                char[] aArr = a.toCharArray();
                char[] bArr = b.toCharArray();
                for(int i = 0; i < aArr.length; i++){
                    if(aArr[i] == bArr[i]){
                        continue;
                    } else {
                        if(aArr[i] > bArr[i]){
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        });
        for(int i = 0; i < nums.length; i++){
            heap.add(nums[i]);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return String.valueOf(heap.poll());
    }
}