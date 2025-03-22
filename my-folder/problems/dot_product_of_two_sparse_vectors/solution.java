class SparseVector {
    HashMap<Integer, Integer> hMap;
    SparseVector(int[] nums) {
        hMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                hMap.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int key : hMap.keySet()){
            if(vec.hMap.containsKey(key)){
                sum += hMap.get(key) * vec.hMap.get(key);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);