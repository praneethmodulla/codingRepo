class Solution {
    public int sumSubarrayMins(int[] arr) {
       long minSum = 0;
       int mod = (int)1e9 + 7;

       int[] nse = new int[arr.length];
       int[] pse = new int[arr.length];

       nse = findNse(arr, nse);
       pse = findPse(arr, pse);

       for(int i = 0; i < arr.length; i++){
         int left = i - pse[i];
         int right = nse[i] - i;
         minSum += (long)(left * right) % mod * arr[i] % mod; 
         minSum %= mod;
       } 
       return (int)minSum;
    }

    public int[] findNse(int[] arr, int[] nse){
        Stack<Integer> st = new Stack<Integer>();
        for(int i = arr.length - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = arr.length;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    
    public int[] findPse(int[] arr, int[] pse){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
}