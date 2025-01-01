class Solution {
    public char kthCharacter(int k) {
        if(k == 1){
            return 'a';
        }
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        int ops = 0;
        recurse(sb, ops, k);
        return sb.charAt(k - 1);
    }

    public void recurse(StringBuilder sb, int ops, int k){
        if(sb.length() >= k){
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == 'z'){
                sb2.append('a');
            } else {
                sb2.append((char)(sb.charAt(i) + 1));
            }
        }
        sb.append(sb2);
        recurse(sb, ops + 1, k);
        return;
    }
}