class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        int number = n;
        long sum = 0;
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - '0';
            if(num > 0){
                sb.append(s.charAt(i));
                sum += num;
            }
        }
        if(sb.length() == 0){
            return 0;
        }
        ans = Long.parseLong(sb.toString());
        return ans * sum;
    }
}