class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for(int i = 0; i < citations.length; i++){
            if(i == 0 || citations[i] != citations[i - 1]){
                ans = Math.max(ans, Math.min(citations[i], citations.length - i));
            }
        }
        return ans;
    }
}