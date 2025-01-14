class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C = new int[A.length];
        C[A.length - 1] = A.length;
        int cnt = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] == B[i]){
                cnt++;
            } else {
                if(!set.isEmpty() && set.contains(A[i])){
                    cnt++;
                }
                if(!set.isEmpty() && set.contains(B[i])){
                    cnt++;
                }
                set.add(A[i]);
                set.add(B[i]);
            }
            C[i] = cnt;
        }
        return C;
    }
}