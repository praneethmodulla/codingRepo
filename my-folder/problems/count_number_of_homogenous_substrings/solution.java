class Solution {
    public int countHomogenous(String s) {
        int i = 0; 
        long count = 0;
        int m = (int)1e9 + 7;
        while(i < s.length()){
            char c = s.charAt(i);
            int start = i;
            while(i < s.length() && s.charAt(i) == c){
                i++;
            }
            long len = i - start;
            count += (len) * (len + 1)/2;
            count = count % m;
        }
        return (int)count;
    }
}