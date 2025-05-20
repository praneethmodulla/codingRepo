class Solution {
    public int hIndex(int[] citations) {
        int low = 0; 
        int high = citations.length - 1;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            ans = Math.max(ans, Math.min(citations[mid], citations.length - mid));
            if(citations[mid] < citations.length - mid){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}