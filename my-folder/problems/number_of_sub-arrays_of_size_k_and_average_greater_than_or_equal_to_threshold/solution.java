class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        for(right = 0; right < arr.length; right++){
            sum += arr[right];
            if(right - left + 1 == k){
                if(sum/k >= threshold){
                    cnt++;
                }
                sum -= arr[left];
                left++;
            }
        }
        return cnt;
    }
}