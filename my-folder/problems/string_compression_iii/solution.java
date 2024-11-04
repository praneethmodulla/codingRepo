class Solution {
    public String compressedString(String word) {
        if(word.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < word.length() - 1; i++){
            if(cnt + 1 != 9 && word.charAt(i) == word.charAt(i + 1)){
                cnt++;
            } else if(cnt + 1 == 9) {
                sb.append((cnt + 1));
                sb.append(word.charAt(i));
                cnt = 0;
            } else if(word.charAt(i) != word.charAt(i + 1)){
                sb.append((cnt + 1));
                sb.append(word.charAt(i));
                cnt = 0;
            }
        }
        sb.append(cnt + 1);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}