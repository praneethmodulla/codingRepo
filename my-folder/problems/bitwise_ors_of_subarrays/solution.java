class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> ans = new HashSet<Integer>();
        HashSet<Integer> cur = new HashSet<Integer>();
        cur.add(0);
        for(int i = 0; i < arr.length; i++){
            HashSet<Integer> cur2 = new HashSet<Integer>();
            for(int num : cur){
                cur2.add(num | arr[i]);
            }
            cur2.add(arr[i]);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}