class Pair{
    int nums1Idx;
    int nums2Idx;
    public Pair(int idx1, int idx2){
        this.nums1Idx = idx1;
        this.nums2Idx = idx2;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<Integer>();
        HashSet<Pair> set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            for(int j =0 ; j < nums1.length; j++){
                if(nums1[j] == nums2[i]){
                    set.add(new Pair(j, i));
                }
            }
        }
        int[] res = new int[nums1.length];
        for(int i = nums2.length - 1; i >= 0; i--){
            if(i == nums2.length - 1){
                nge[i] = -1;
                st.push(nums2[i]);
                continue;
            }
            while(!st.isEmpty() && nums2[i] > st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
                st.push(nums2[i]);
            } else {
                nge[i] = st.peek();
                st.push(nums2[i]);
            }
        }
        for(Pair p : set){
            res[p.nums1Idx] = nge[p.nums2Idx];
        }
        return res;
    }
}