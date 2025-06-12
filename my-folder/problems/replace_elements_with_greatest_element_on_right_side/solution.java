class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2; i >=0; i--){
            if(max < arr[i]){
                result[i] = max;
                max = arr[i]; 
            } else {
                result[i] = max;
            }
        }
        return result;
    }
}