class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++){
            map.add(nums1[i]);
        }
        HashSet<Integer> result = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; i++){
            if(map.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] res = new int[result.size()];
        int k = 0;
        for(int i : result){
            res[k] = i; 
            k++;
        }
        return res;
    }
}