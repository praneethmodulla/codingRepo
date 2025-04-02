class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] ch = s.toCharArray();
        int[] maxSoFar = new int[ch.length];
        maxSoFar[ch.length - 1] = ch.length - 1;
        for(int i = ch.length - 2; i >= 0; i--){
            if(ch[i] <= ch[maxSoFar[i + 1]]){
                maxSoFar[i] = maxSoFar[i + 1];
            } else {
                maxSoFar[i] = i;
            }
        }
        for(int i = 0; i < ch.length; i++){
            if(ch[i] < ch[maxSoFar[i]]){
                char temp = ch[i];
                ch[i] = ch[maxSoFar[i]];
                ch[maxSoFar[i]] = temp;
                break;
            }
        }
        String ans = new String(ch);
        return Integer.valueOf(ans);
    }
}