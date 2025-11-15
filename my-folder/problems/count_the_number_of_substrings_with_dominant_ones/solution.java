class Solution {
    public int numberOfSubstrings(String s) {
        int[] pre = new int[s.length() + 1];
        pre[0] = -1;
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || (i > 0 && s.charAt(i - 1) == '0')){
                pre[i + 1] = i;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        int count = 0;
        for(int i = 1; i <= s.length(); i++){
            int cnt0 = 0;
            if(s.charAt(i - 1) == '0'){
                cnt0++;
            }
            int j = i;
            while(j > 0 && cnt0 * cnt0 <= s.length()){
                int cnt1 = i - pre[j] - cnt0;
                if(cnt0 * cnt0 <= cnt1){
                    count += Math.min(j - pre[j], cnt1 - cnt0 * cnt0 + 1);
                }
                j = pre[j];
                cnt0++;
            }
        }
        return count;
    }
}