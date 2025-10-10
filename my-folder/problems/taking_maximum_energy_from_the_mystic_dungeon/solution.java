class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        int[] arr = new int[energy.length];
        arr[energy.length - 1] = energy[energy.length - 1];
        max = arr[energy.length - 1];
        for(int i = energy.length - 2; i >= 0; i--){
            if(i + k >= energy.length){
                arr[i] = energy[i];
            } else {
                arr[i] = energy[i] + arr[i + k];
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }
}