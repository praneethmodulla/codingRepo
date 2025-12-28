class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int counter = 0;
        int i = happiness.length - 1;
        while(k > 0){
            long num = Math.max(0, happiness[i] - counter);
            ans += num;
            counter++;
            k--;
            i--;
        }
        return ans;
    }
}