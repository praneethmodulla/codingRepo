class Solution {
    public int numSub(String s) {
        int start = -1;
        long count = 0;
        int m = (int)(1e9 + 7);
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '1'){
                start = i;
                while(i < s.length() && s.charAt(i) == '1'){
                    i++;
                }
                long len = i - start;
                count += (len) * (len + 1)/2;
                count = count % m; 
            } else {
                i++;
            }
        }
        return (int) count;
    }
}